/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Dokkuhai
 */
public class PersonAddress {
    private Person person;
    private String address;
    private int isPrimary;

    public PersonAddress(Person person, String address, int isPrimary) {
        this.person = person;
        this.address = address;
        this.isPrimary = isPrimary;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(int isPrimary) {
        this.isPrimary = isPrimary;
    }

    @Override
    public String toString() {
        return "PersonAddress{" + "person=" + person + ", address=" + address + ", isPrimary=" + isPrimary + '}';
    }
    
    
}
