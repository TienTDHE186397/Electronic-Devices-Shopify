/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.*;
import java.lang.*;

public class Categories {

    private int CategoryID;
    private String CategoryName;

    public Categories() {
    }

    public Categories(int CategoryID, String CategoryName) {
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    @Override
    public String toString() {
        return "Categories{" + "CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + '}';
    }

    
    
    
    

  
    
    
}
