/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author admin
 */
  import junit.framework.TestCase;  
    public class TestPersonnn extends TestCase {  
        public TestPersonnn(String name) {  
            super(name);  
        }  
        /** 
            * Xac nhan rang name duoc the hien dung dinh dang 
        */  
        public void testGetFullName() {  
            Personnn2 p = new Personnn2("Aidan", "Burke");  
            assertEquals("Aidan Burke", p.getFullName());  
        }  
        /** 
        * Xac nhan rang nulls da duoc xu ly chinh xac 
        */  
        public void testNullsInName() {  
            Personnn2 p = new Personnn2(null, "Burke");  
            assertEquals("? Burke", p.getFullName());  
            p = new Personnn2("Tanner", null);  
            assertEquals("Tanner ?", p.getFullName());  
        }  
    }
