package DAO;

import Entity.Categories;

import Entity.Product;
import java.util.*;
import java.lang.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//Trung

public class ProductListDAO extends DBContext {

    CategoryDAO cDAO = new CategoryDAO();
    // Lấy Tất Cả Product
    public List<Product> getAllProduct() {
        List<Product> listP = new ArrayList<>();
        String sql = "Select * from Products";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Categories cate = cDAO.getCategoriesById(rs.getInt("CategoryID"));
                Product p = new Product(rs.getInt("ProductID"),
                        rs.getString("title"),
                        rs.getString("ProductName"),
                        rs.getInt("Views"), rs.getDate("releaseDate"),
                        rs.getInt("QuantitySold"),
                        cate,
                        rs.getInt("Quantity"),
                        rs.getInt("Sale"),
                        rs.getString("img"),
                        rs.getDouble("price"),
                        rs.getString("publisher"),
                        rs.getString("sortDescription"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getString("brand"));
                listP.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listP;
    }
    // Tìm Kiếm Product
    public List<Product> searchProduct(String search, String fromprice,
            String toprice, String shortdescription,
            String category_id, String status,
            String sort, int page, int perpage) {
        List<Product> listP = new ArrayList<>();

        int pageget = (page * perpage - perpage);

        String sql = "select \n"
                + "  p.[ProductID]\n"
                + "      ,p.[title]\n"
                + "      ,p.[ProductName]\n"
                + "      ,p.[Views]\n"
                + "      ,p.[releaseDate]\n"
                + "      ,p.[QuantitySold]\n"
                + "      ,p.[CategoryID]\n"
                + "      ,p.[Quantity]\n"
                + "      ,p.[Sale]\n"
                + "      ,p.[brand]\n"
                + "      ,p.[img]\n"
                + "      ,p.[price]\n"
                + "      ,p.[publisher]\n"
                + "      ,p.[sortDescription]\n"
                + "      ,p.[description]\n"
                + "      ,p.[status]\n"
                + "  from Products p , Categories c\n"
                + "  Where p.CategoryID = c.CategoryID ";
        try {
            if (!search.isEmpty()) {
                sql += "AND (p.ProductName like N'%" + search + "%' OR p.brand like N'%" + search + "%' OR p.title like N'%" + search + "%') ";
            }
            if (!fromprice.isEmpty()) {
                sql += "AND  p.price >=" + Integer.parseInt(fromprice) + " ";
            }
            if (!toprice.isEmpty()) {
                sql += "AND p.price <=" + Integer.parseInt(toprice) + " ";
            }
            if (!shortdescription.isEmpty()) {
                sql += "AND p.sortDescription like N'%" + shortdescription + "%' ";
            }
            if (!category_id.equals("0")) {
                sql += "AND p.CategoryID = " + Integer.parseInt(category_id) + " ";
            }
            if (!status.isEmpty()) {
                sql += "AND p.status like '" + status + "' ";
            }
            if (!sort.equals("0")) {
                if (sort.equals("1")) {
                    sql += "ORDER BY p.title ASC \n";
                }
                if (sort.equals("2")) {
                    sql += "ORDER BY p.title DESC \n";
                }
                if (sort.equals("3")) {
                    sql += "ORDER BY c.CategoryID ASC \n";
                }
                if (sort.equals("4")) {
                    sql += "ORDER BY c.CategoryID DESC \n";
                }
                if (sort.equals("5")) {
                    sql += "ORDER BY p.price ASC \n";
                }
                if (sort.equals("6")) {
                    sql += "ORDER BY p.price DESC \n";
                }
                if (sort.equals("7")) {
                    sql += "ORDER BY p.price - ((p.Sale)*(p.price)) ASC \n";
                }
                if (sort.equals("8")) {
                    sql += "ORDER BY p.price - ((p.Sale)*(p.price)) DESC \n";
                }
            }
            if (sort.isEmpty() || sort.equals("0")) {
                sql += "ORDER BY p.ProductID \n";
            }

            sql += "OFFSET " + pageget + " ROWS\n"
                    + "FETCH NEXT " + perpage + " ROWS ONLY";

        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Categories cate = cDAO.getCategoriesById(rs.getInt("CategoryID"));
                Product p = new Product(rs.getInt("ProductID"),
                        rs.getString("title"),
                        rs.getString("ProductName"),
                        rs.getInt("Views"), rs.getDate("releaseDate"),
                        rs.getInt("QuantitySold"),
                        cate,
                        rs.getInt("Quantity"),
                        rs.getInt("Sale"),
                        rs.getString("img"),
                        rs.getDouble("price"),
                        rs.getString("publisher"),
                        rs.getString("sortDescription"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getString("brand"));
                listP.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listP;
    }
    public List<Product> searchProduct2(String search, String fromprice,
            String toprice, String shortdescription,
            String category_id, String status,
            String sort) {
        List<Product> listP = new ArrayList<>();
        String sql = "select \n"
                + "  p.[ProductID]\n"
                + "      ,p.[title]\n"
                + "      ,p.[ProductName]\n"
                + "      ,p.[Views]\n"
                + "      ,p.[releaseDate]\n"
                + "      ,p.[QuantitySold]\n"
                + "      ,p.[CategoryID]\n"
                + "      ,p.[Quantity]\n"
                + "      ,p.[Sale]\n"
                + "      ,p.[brand]\n"
                + "      ,p.[img]\n"
                + "      ,p.[price]\n"
                + "      ,p.[publisher]\n"
                + "      ,p.[sortDescription]\n"
                + "      ,p.[description]\n"
                + "      ,p.[status]\n"
                + "  from Products p , Categories c\n"
                + "  Where p.CategoryID = c.CategoryID ";
        try {
            if (!search.isEmpty()) {
                sql += "AND (p.ProductName like N'%" + search + "%' OR p.brand like N'%" + search + "%' OR p.title like N'%" + search + "%') ";
            }
            if (!fromprice.isEmpty()) {
                sql += "AND  p.price >=" + Integer.parseInt(fromprice) + " ";
            }
            if (!toprice.isEmpty()) {
                sql += "AND p.price <=" + Integer.parseInt(toprice) + " ";
            }
            if (!shortdescription.isEmpty()) {
                sql += "AND p.sortDescription like N'%" + shortdescription + "%' ";
            }
            if (Integer.parseInt(category_id) != 0) {
                sql += "AND p.CategoryID = " + Integer.parseInt(category_id) + " ";
            }
            if (!status.isEmpty()) {
                sql += "AND p.status like '" + status + "' ";
            }
            if (!sort.equals("0")) {
                if (sort.equals("1")) {
                    sql += "ORDER BY p.title ASC";
                }
                if (sort.equals("2")) {
                    sql += "ORDER BY p.title DESC";
                }
                if (sort.equals("3")) {
                    sql += "ORDER BY c.CategoryID ASC";
                }
                if (sort.equals("4")) {
                    sql += "ORDER BY c.CategoryID DESC";
                }
                if (sort.equals("5")) {
                    sql += "ORDER BY p.price ASC";
                }
                if (sort.equals("6")) {
                    sql += "ORDER BY p.price DESC";
                }
                if (sort.equals("7")) {
                    sql += "ORDER BY p.price - ((p.Sale)*(p.price)) ASC";
                }
                if (sort.equals("8")) {
                    sql += "ORDER BY p.price - ((p.Sale)*(p.price)) DESC";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Categories cate = cDAO.getCategoriesById(rs.getInt("CategoryID"));
                Product p = new Product(rs.getInt("ProductID"),
                        rs.getString("title"),
                        rs.getString("ProductName"),
                        rs.getInt("Views"), rs.getDate("releaseDate"),
                        rs.getInt("QuantitySold"),
                        cate,
                        rs.getInt("Quantity"),
                        rs.getInt("Sale"),
                        rs.getString("img"),
                        rs.getDouble("price"),
                        rs.getString("publisher"),
                        rs.getString("sortDescription"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getString("brand"));
                listP.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listP;
    }
    // Thêm Mới Bài Đăng
    public void addNewProduct(Product p, Categories c) {

        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([title]\n"
                + "           ,[ProductName]\n"
                + "           ,[Views]\n"
                + "           ,[releaseDate]\n"
                + "           ,[QuantitySold]\n"
                + "           ,[CategoryID]\n"
                + "           ,[Quantity]\n"
                + "           ,[Sale]\n"
                + "           ,[brand]\n"
                + "           ,[img]\n"
                + "           ,[price]\n"
                + "           ,[publisher]\n"
                + "           ,[sortDescription]\n"
                + "           ,[description]\n"
                + "           ,[status])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getTitle());
            st.setString(2, p.getProductName());
            st.setInt(3, p.getViews());
            st.setDate(4, (java.sql.Date) p.getReleaseDate());
            st.setInt(5, p.getQuantitySold());
            st.setInt(6, c.getCategoryID());
            st.setInt(7, p.getQuantity());
            st.setInt(8, p.getSale());
            st.setString(9, p.getBrand());
            st.setString(10, p.getImg());
            st.setDouble(11, p.getPrice());
            st.setString(12, p.getPublisher());
            st.setString(13, p.getSortDescription());
            st.setString(14, p.getDescription());
            st.setString(15, p.getStatus());
            st.executeUpdate();
        } catch (Exception e) {

            System.out.println(e);

        }

    }
    // Lấy Product từ Ngày Nào Đến Ngày Nào
    public List<Product> getProductMKTDashBoard(String fromdate, String todate) {

        List<Product> list = new ArrayList<>();

        String sql = "Select * From Products Where releaseDate BETWEEN '" + fromdate + "' AND '" + todate + "'";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Categories cate = cDAO.getCategoriesById(rs.getInt("CategoryID"));
                Product p = new Product(rs.getInt("ProductID"),
                        rs.getString("title"),
                        rs.getString("ProductName"),
                        rs.getInt("Views"), rs.getDate("releaseDate"),
                        rs.getInt("QuantitySold"),
                        cate,
                        rs.getInt("Quantity"),
                        rs.getInt("Sale"),
                        rs.getString("img"),
                        rs.getDouble("price"),
                        rs.getString("publisher"),
                        rs.getString("sortDescription"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getString("brand"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        ProductListDAO p = new ProductListDAO();
        List<Product> list = p.getAllProduct();
        for (Product l : list) {
            System.out.println(l);
        }
        //      System.out.println(p.searchProduct("", "", "", "", "0", "", "1"));
    }

}
