package Entity;

import java.sql.Date;
import java.time.LocalDate;

public class Person {

    private int PersonID;
    private String Name;
    private String Gender;
    private String DateOfBirth;
    private LocalDate StartDate;
    private String Address;
    private String Email;
    private String Phone;
    private int roleID;
    private String Pasword;

    public Person(String Name, String Gender, String DateOfBirth, LocalDate StartDate, String Address, String Email, String Phone, int roleID, String Pasword) {
        this.Name = Name;
        this.Gender = Gender;
        this.DateOfBirth = DateOfBirth;
        this.StartDate = StartDate;
        this.Address= Address;
        this.Email = Email;
        this.Phone = Phone;
        this.roleID = roleID;
        this.Pasword = Pasword;

    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate StartDate) {
        this.StartDate = StartDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getPasword() {
        return Pasword;
    }

    public void setPasword(String Pasword) {
        this.Pasword = Pasword;
    }

    @Override
    public String toString() {
return "Person{" + "PersonID=" + PersonID + ", Name=" + Name + ", Gender=" + Gender + ", DateOfBirth=" + DateOfBirth + ", StartDate=" + StartDate + ", Address=" + Address + ", Email=" + Email + ", Phone=" + Phone + ", roleID=" + roleID + ", Pasword=" + Pasword + '}';
    }

}