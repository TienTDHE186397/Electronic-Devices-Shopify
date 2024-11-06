/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Dokkuhai
 */
public class PersonPhone {
     private Person person;
    private String phone;
    private int isPrimary;

    public PersonPhone(Person person, String phone, int isPrimary) {
        this.person = person;
        this.phone = phone;
        this.isPrimary = isPrimary;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String phone) {
        this.phone = phone;
    }

    public int getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(int isPrimary) {
        this.isPrimary = isPrimary;
    }

    @Override
    public String toString() {
        return "PersonAddress{" + "person=" + person + ", phone=" + phone + ", isPrimary=" + isPrimary + '}';
    }
}
