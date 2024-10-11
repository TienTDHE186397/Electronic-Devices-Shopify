/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author nghie
 */
public class Setting {
    private int ID;
    private String Type, Value;
    private int Order;
    private String Status;
    private String Image;
    private int page;

    public Setting() {
    }

    public Setting(int ID, String Type, String Value, String Image, int Order, String Status) {
        this.ID = ID;
        this.Type = Type;
        this.Value = Value;
        this.Image = Image;
        this.Order = Order;
        this.Status = Status;
    }
    public Setting(String Type, String Value, String Image, int Order, String Status) {
        this.Type = Type;
        this.Value = Value;
        this.Image = Image;
        this.Order = Order;
        this.Status = Status;
    }
    

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    public int getOrder() {
        return Order;
    }

    public void setOrder(int Order) {
        this.Order = Order;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Setting{" + "ID=" + ID + ", Type=" + Type + ", Value=" + Value + ", Order=" + Order + ", Status=" + Status + ", Image=" + Image + '}';
    }
    
}
