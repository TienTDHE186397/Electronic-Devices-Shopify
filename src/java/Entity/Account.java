/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author dutpr
 */
public class Account {
    private int ID;
    private String user;
    private String pass;
    private int age;
    private int roleID;
    private int isSell;

    public Account() {
    }

    public Account(int ID, String user, String pass, int age, int roleID, int isSell) {
        this.ID = ID;
        this.user = user;
        this.pass = pass;
        this.age = age;
        this.roleID = roleID;
        this.isSell = isSell;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    @Override
    public String toString() {
        return "Account{" + "ID=" + ID + ", user=" + user + ", pass=" + pass + ", age=" + age + ", roleID=" + roleID +", isSell=" + isSell + '}';
    }
    
}


