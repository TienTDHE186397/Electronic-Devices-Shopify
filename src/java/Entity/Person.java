/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Person {
    
//     [PersonID] [int] IDENTITY(1,1) NOT NULL,
//	[Name ] [nvarchar](50) NULL,
//	[Gender] [nvarchar](6) NULL,
//	[DateOfBirth] [date] NULL,
//	[Email] [varchar](100) NULL,
//	[Phone] [varchar](15) NULL,
    
    private int PersonID;
    private String name;
    private String gender;
    private Date birth;
    private String email;
    private int roleID;
    private String roleName;
    private String username;

    public Person() {
    }

    public Person(int PersonID, String name, String gender, Date birth, String email,int roleID, String roleName, String username) {
        this.PersonID = PersonID;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.email = email;
        this.roleID = roleID;
        this.roleName = roleName;
        this.username = username;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    
    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  
    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Person{" + "PersonID=" + PersonID + ", name=" + name + ", gender=" + gender + ", birth=" + birth +  ", roleID=" + roleID + ", roleName=" + roleName + ", username=" + username + '}';
    }
    
    
    
    
}
