/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.FoodAndDrink;
import Entity.Product;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FoodAndDrinkDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<FoodAndDrink> getAllProduct() {
        List<FoodAndDrink> list = new ArrayList<>();
        String query = "Select * from FoodandDrink";
        try {
            conn = new DBContext().getConnection(); //mo ket noi voi sqsl
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FoodAndDrink(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        FoodAndDrinkDAO dao = new FoodAndDrinkDAO();
        List<FoodAndDrink> list = dao.getAllProduct();
        for (FoodAndDrink o : list) {
            System.out.println(o);
        }
    }
}
