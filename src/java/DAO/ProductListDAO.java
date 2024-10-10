
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
    

    public List<Product> getAllProduct() {

        List<Product> listP = new ArrayList<>();

        String sql = "Select * from Products";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
          

            while (rs.next()) {
                Categories cate = cDAO.getCategoriesById(rs.getInt("CategoryID"));

                Product p = new Product(rs.getInt("ProductID"),rs.getString("title"), rs.getString("ProductName"),
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
                        rs.getString("brand"),
                        rs.getString("status"));
              

                listP.add(p);
            
            }

        } catch (Exception e) {
                e.printStackTrace();
        }

        return listP;

    }

   

    public static void main(String[] args) {

        ProductListDAO p = new ProductListDAO();

        List<Product> list = p.getAllProduct();
        
        for(Product l : list) {
            
            System.out.println(l);
        }

        
    }

}
