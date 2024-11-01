package Entity;

import java.sql.Date;
import java.time.LocalDate;

public class Person {

    private int PersonID;
    private String Image;
    private String Name;
    private String Gender;
    private String DateOfBirth;
    private LocalDate StartDate;
    private String Address;
    private String Email;
    private String Phone;
    private int roleID;
    private String Pasword;
//cua son

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public Person() {
    }
   
    public Person(String Name, String Gender, String DateOfBirth, LocalDate StartDate, String Address, String Email, String Phone, int roleID, String Pasword) {
        this.Name = Name;
        this.Gender = Gender;
        this.DateOfBirth = DateOfBirth;
        this.StartDate = StartDate;
        this.Address = Address;
        this.Email = Email;
        this.Phone = Phone;
        this.roleID = roleID;
        this.Pasword = Pasword;

    }

    //cua duc
//    public Person(int PersonID, String Name, String Gender, String DateOfBirth, LocalDate StartDate, String Address, String Email, String Phone, int RoleID, String Password) {
//        this.PersonID = PersonID;
//        this.Name = Name;
//        this.Gender = Gender;
//        this.DateOfBirth = DateOfBirth;
//        this.StartDate = StartDate;
//        this.Address = Address;
//        this.Email = Email;
//        this.Phone = Phone;
//        this.roleID = RoleID;
//        this.Pasword = Password;
//    }
//
//    public Person(String Name, String Gender, String Address, String Email, String Phone, int RoleID, String Password) {
//        this.Name = Name;
//        this.Gender = Gender;
//        this.Address = Address;
//        this.Email = Email;
//        this.Phone = Phone;
//        this.roleID = RoleID;
//        this.Pasword = Password;
//    }
//
//    public Person(String Name, String Address, String Phone, String Password) {
//        this.Name = Name;
//        this.Address = Address;
//        this.Phone = Phone;
//        this.Pasword = Password;
//    }
    public Person(int PersonID, String Name, int RoleID){
        this.PersonID = PersonID;
        this.Name = Name;
        this.roleID = RoleID;
        
    }
    public Person(String image, String Name, String Gender, String DateOfBirth, LocalDate StartDate, String Address, String Email, String Phone, int roleID, String Pasword) {
        this.Image = image;
        this.Name = Name;
        this.Gender = Gender;
        this.DateOfBirth = DateOfBirth;
        this.StartDate = StartDate;
        this.Address = Address;
        this.Email = Email;
        this.Phone = Phone;
        this.roleID = roleID;
        this.Pasword = Pasword;

    }
    
    public Person(int PersonID,String Images, String Name, String Gender, String DateOfBirth, LocalDate StartDate, String Address, String Email, String Phone, int RoleID, String Password) {
        this.PersonID = PersonID;
        this.Image = Images;
        this.Name = Name;
        this.Gender = Gender;
        this.DateOfBirth = DateOfBirth;
        this.StartDate = StartDate;
        this.Address = Address;
        this.Email = Email;
        this.Phone = Phone;
        this.roleID = RoleID;
        this.Pasword = Password;
    }
    
    public Person(int PersonID, String Name, String Gender, String DateOfBirth, LocalDate StartDate, String Email, int RoleID, String Password) {
        this.PersonID = PersonID;
        this.Name = Name;
this.Gender = Gender;
        this.DateOfBirth = DateOfBirth;
        this.StartDate = StartDate;
        this.Email = Email;
        this.roleID = RoleID;
        this.Pasword = Password;
    }

    public Person(String Images,String Name, String Gender, String Address, String Email, String Phone, int RoleID, String Password) {
        this.Image = Images;
        this.Name = Name;
        this.Gender = Gender;
        this.Address = Address;
        this.Email = Email;
        this.Phone = Phone;
        this.roleID = RoleID;
        this.Pasword = Password;
    }

    public Person(String Images,String Name, String Address, String Phone, String Password) {
        this.Image = Images;
        this.Name = Name;
        this.Address = Address;
        this.Phone = Phone;
        this.Pasword = Password;
    }
    public Person(int PersonID,String Images, String Name, int RoleID){
        this.PersonID = PersonID;
        this.Image = Images;
        this.Name = Name;
        this.roleID = RoleID;
        
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