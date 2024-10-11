/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author admin
 */
public class ProductAttribute {
    private int AttributeID;
    private String AttributeName;
    private String AttributeValue;

    public ProductAttribute() {
    }

    public ProductAttribute(int AttributeID,String AttributeName, String AttributeValue) {
        this.AttributeID = AttributeID;
        this.AttributeName = AttributeName;
        this.AttributeValue = AttributeValue;
    }
    
    public int getAttributeID() {
        return AttributeID;
    }

    public void setAttributeID(int AttributeID) {
        this.AttributeID = AttributeID;
    }

    
    public String getAttributeName() {
        return AttributeName;
    }

    public void setAttributeName(String AttributeName) {
        this.AttributeName = AttributeName;
    }

    public String getAttributeValue() {
        return AttributeValue;
    }

    public void setAttributeValue(String AttributeValue) {
        this.AttributeValue = AttributeValue;
    }

    @Override
    public String toString() {
        return "ProductAttribute{" + "AttributeID=" + AttributeID + ", AttributeName=" + AttributeName + ", AttributeValue=" + AttributeValue + '}';
    }
    
}
