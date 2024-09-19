package Entity;

import java.util.*;
import java.lang.*;

public class Person {
    
    private int person;
    private String name;
    private String gender;
    private Date DateOfBirth;
    private String address;
    private String email;
    private String phone;
    private int RoleId;
    private String password;

    public Person() {
    }

    public Person(int person, String name, String gender, Date DateOfBirth, String address, String email, String phone, int RoleId, String password) {
        this.person = person;
        this.name = name;
        this.gender = gender;
        this.DateOfBirth = DateOfBirth;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.RoleId = RoleId;
        this.password = password;
    }

    public int getPerson() {
        return person;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getRoleId() {
        return RoleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRoleId(int RoleId) {
        this.RoleId = RoleId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    


}
