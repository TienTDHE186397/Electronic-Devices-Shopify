/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Admin
 */
public class Cinema {
    private int cinemaid;
    private String cinemaname;
    private String address;

    public Cinema() {
    }

    public Cinema(int cinemaid, String cinemaname, String address) {
        this.cinemaid = cinemaid;
        this.cinemaname = cinemaname;
        this.address = address;
    }

    public int getCinemaid() {
        return cinemaid;
    }

    public void setCinemaid(int cinemaid) {
        this.cinemaid = cinemaid;
    }

    public String getCinemaname() {
        return cinemaname;
    }

    public void setCinemaname(String cinemaname) {
        this.cinemaname = cinemaname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Cinema{" + "cinemaid=" + cinemaid + ", cinemaname=" + cinemaname + ", address=" + address + '}';
    }
    
    
}
