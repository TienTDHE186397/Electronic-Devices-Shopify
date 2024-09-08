/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Admin
 */
public class Calendar2 {
    private int calendarId;
    private int cinemaId;
    private String productName;
    private String movieDate;
    private String slot1;
    private String slot2;
    private String slot3;
    private String slot4;
    private String slot5;
    private int roomId;
    private int status;

    public Calendar2() {
    }

    public Calendar2(int calendarId, int cinemaId, String productName, String movieDate, String slot1, String slot2, String slot3, String slot4, String slot5, int roomId, int status) {
        this.calendarId = calendarId;
        this.cinemaId = cinemaId;
        this.productName = productName;
        this.movieDate = movieDate;
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.slot3 = slot3;
        this.slot4 = slot4;
        this.slot5 = slot5;
        this.roomId = roomId;
        this.status = status;
    }

    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getSlot1() {
        return slot1;
    }

    public void setSlot1(String slot1) {
        this.slot1 = slot1;
    }

    public String getSlot2() {
        return slot2;
    }

    public void setSlot2(String slot2) {
        this.slot2 = slot2;
    }

    public String getSlot3() {
        return slot3;
    }

    public void setSlot3(String slot3) {
        this.slot3 = slot3;
    }

    public String getSlot4() {
        return slot4;
    }

    public void setSlot4(String slot4) {
        this.slot4 = slot4;
    }

    public String getSlot5() {
        return slot5;
    }

    public void setSlot5(String slot5) {
        this.slot5 = slot5;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
