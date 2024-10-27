package Entity;

import java.sql.Date;
import java.time.LocalDate;

public class Person {

    private int PersonID;
    private String Name;
    private String Gender;
    private String DateOfBirth;
    private LocalDate StartDate;
    private String Email;
    private int roleID;
    private String Pasword;
//cua son

    public Person(String Name, String Gender, String DateOfBirth, LocalDate StartDate, String Address, String Email, String Phone, int roleID, String Pasword) {
        this.Name = Name;
        this.Gender = Gender;
        this.DateOfBirth = DateOfBirth;
        this.StartDate = StartDate;
        this.Email = Email;
        this.roleID = roleID;
        this.Pasword = Pasword;

    }

    //cua duc
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

    public Person(String Name, String Gender, String Email, LocalDate startDate, String Password, int RoleID, String password) {
        this.Name = Name;
        this.Gender = Gender;

        this.Email = Email;

        this.roleID = RoleID;
        this.Pasword = Password;
    }

    public Person(String Name, String Password) {
        this.Name = Name;
        this.Pasword = Password;
    }

    public Person(int PersonID, String Name, int RoleID) {
        this.PersonID = PersonID;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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
        return "Person{" + "PersonID=" + PersonID + ", Name=" + Name + ", Gender=" + Gender + ", DateOfBirth=" + DateOfBirth + ", StartDate=" + StartDate + ", Email=" + Email + ", roleID=" + roleID + ", Pasword=" + Pasword + '}';
    }

}
