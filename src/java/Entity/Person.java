package Entity;

<<<<<<< HEAD
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
    private Role RoleId;
    private String password;
=======
import java.sql.Date;

public class Person {

    private int PersonID;
    private String Name;
    private String Gender;
    private String DateOfBirth;
    private String StartDate;
    private String Address;
    private String Email;
    private String Phone;
    private int roleID;
    private String Pasword;
>>>>>>> 73bfbee9d457f695ae4defefabbc3ceffb151c11

    public Person() {
    }

<<<<<<< HEAD
    public Person(int person, String name, String gender, Date DateOfBirth, String address, String email, String phone, Role RoleId, String password) {
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
=======
    public Person(int PersonID, String Name, String Gender, String DateOfBirth, String Address, String Email, String Phone, int roleID, String Pasword, String code) {
        this.PersonID = PersonID;
        this.Name = Name;
        this.Gender = Gender;
        this.DateOfBirth = DateOfBirth;
        this.Address = Address;
        this.Email = Email;
        this.Phone = Phone;
        this.roleID = roleID;
        this.Pasword = Pasword;

    }

    public Person(String Name, String Gender, String DateOfBirth, String StartDate, String Address, String Email, String Phone, int roleID, String Pasword) {
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

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
>>>>>>> 73bfbee9d457f695ae4defefabbc3ceffb151c11
    }

    public String getName() {
        return Name;
    }

<<<<<<< HEAD
=======
    public void setName(String Name) {
        this.Name = Name;
    }

>>>>>>> 73bfbee9d457f695ae4defefabbc3ceffb151c11
    public String getGender() {
        return Gender;
    }

<<<<<<< HEAD
    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public String getAddress() {
        return address;
=======
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
>>>>>>> 73bfbee9d457f695ae4defefabbc3ceffb151c11
    }

    public String getEmail() {
        return Email;
    }

<<<<<<< HEAD
    public String getPhone() {
        return phone;
    }

    public Role getRoleId() {
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
=======
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
>>>>>>> 73bfbee9d457f695ae4defefabbc3ceffb151c11
    }

    public void setRoleId(Role RoleId) {
        this.RoleId = RoleId;
    }

<<<<<<< HEAD
    public void setPassword(String password) {
        this.password = password;
    }
    
    
=======
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
>>>>>>> 73bfbee9d457f695ae4defefabbc3ceffb151c11

}
