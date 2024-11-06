package Controller;

import DAO.CartDAO;
import DAO.CartItemDAO;
import DAO.ProductDAO;
import Entity.Cart;
import Entity.CartItem;
import Entity.Person;
import Entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

//@WebServlet(name = "CartController", urlPatterns = {"/cart", "/cart/add", "/cart/update", "/cart/delete"})
public class CartController extends HttpServlet {

    private CartDAO cartDAO = new CartDAO();
    private CartItemDAO cartItemDAO = new CartItemDAO();
    private ProductDAO productDAO = new ProductDAO(); // Để lấy thông tin sản phẩm

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/cart":
                viewCart(request, response);
                break;
            case "/cart/delete":
                deleteCartItem(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/cart/add":
                addCartItem(request, response);
                break;
            case "/cart/update":
                updateCartItem(request, response);
                break;
            default:
                break;
        }
    }

    private void viewCart(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession session = request.getSession();
    Person person = (Person) session.getAttribute("person"); // Lấy đối tượng Person từ session

    if (person != null) {
        Cart cart = cartDAO.getCartByPersonId(person.getPersonID()); // Sử dụng personID

        // Nếu không có giỏ hàng, tạo một giỏ hàng mới
        if (cart == null) {
            cart = new Cart();
            cart.setPerson(person); // Gán đối tượng Person vào giỏ hàng
            cart.setStatus(0); // Đặt trạng thái giỏ hàng (0 cho giỏ hàng mới)
            int cartId = cartDAO.createCart(person.getPersonID()); // Tạo giỏ hàng mới trong database
            cart.setCartID(cartId); // Gán CartID cho giỏ hàng
        }

        request.setAttribute("cart", cart);
        request.getRequestDispatcher("/view/cart.jsp").forward(request, response); // Chuyển tới trang hiển thị giỏ hàng
    } else {
        response.sendRedirect(request.getContextPath() + "/login"); // Chuyển hướng đến trang đăng nhập nếu chưa đăng nhập
    }
}

    private void addCartItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer personId = (Integer) session.getAttribute("personId"); // Lấy ID người dùng từ session

        if (personId != null) {
            int cartId = cartDAO.createCart(personId); // Tạo giỏ hàng mới hoặc lấy giỏ hàng đã tồn tại
            int productId = Integer.parseInt(request.getParameter("ProductID"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Product product = productDAO.getProductsById(productId); // Lấy thông tin sản phẩm

            if (product != null) {
                cartItemDAO.addCartItem(cartId, product, quantity); // Thêm sản phẩm vào giỏ hàng
            }

            response.sendRedirect(request.getContextPath() + "/cart"); // Chuyển hướng về giỏ hàng
        } else {
            response.sendRedirect(request.getContextPath() + "/login"); // Chuyển hướng đến trang đăng nhập nếu chưa đăng nhập
        }
    }

    private void updateCartItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cartItemId = Integer.parseInt(request.getParameter("cartItemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        cartItemDAO.updateCartItemQuantity(cartItemId, quantity); // Cập nhật số lượng sản phẩm trong giỏ hàng

        response.sendRedirect(request.getContextPath() + "/cart"); // Chuyển hướng về giỏ hàng
    }

    private void deleteCartItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cartItemId = Integer.parseInt(request.getParameter("cartItemId"));
        cartItemDAO.deleteCartItem(cartItemId); // Xóa sản phẩm khỏi giỏ hàng

        response.sendRedirect(request.getContextPath() + "/cart"); // Chuyển hướng về giỏ hàng
    }
}