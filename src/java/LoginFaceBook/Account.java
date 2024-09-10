/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginFaceBook;

import LoginGoogle.*;
import com.google.gson.JsonObject;

/**
 *
 * @author admin
 */
public class Account {
    private String id,name,email;
    private JsonObject picture;

    public Account() {
    }

    public Account(String id, String name, String email, JsonObject picture) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JsonObject getPicture() {
        return picture;
    }

    public void setPicture(JsonObject picture) {
        this.picture = picture;
    }

   

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name=" + name + ", email=" + email + ", picture=" + picture + '}';
    }

   
    
}
