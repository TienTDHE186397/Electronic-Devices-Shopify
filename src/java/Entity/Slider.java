/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Entity;


import java.util.*;
import java.lang.*;


public class Slider {
    
    private int slider_id;
    private String slider_tittle;
    private String slider_image;
    private String slider_video;
    private String slider_backlink;
    private String slider_date;
    private String slider_status;
    private String slider_note;
    private Person person;

    public Slider() {
    }

    public Slider(int slider_id, String slider_tittle, String slider_image, String slider_video, String slider_backlink, String slider_date, String slider_status, String slider_note, Person person) {
        this.slider_id = slider_id;
        this.slider_tittle = slider_tittle;
        this.slider_image = slider_image;
        this.slider_video = slider_video;
        this.slider_backlink = slider_backlink;
        this.slider_date = slider_date;
        this.slider_status = slider_status;
        this.slider_note = slider_note;
        this.person = person;
    }

    public int getSlider_id() {
        return slider_id;
    }

    public void setSlider_id(int slider_id) {
        this.slider_id = slider_id;
    }

    public String getSlider_tittle() {
        return slider_tittle;
    }

    public void setSlider_tittle(String slider_tittle) {
        this.slider_tittle = slider_tittle;
    }

    public String getSlider_image() {
        return slider_image;
    }

    public void setSlider_image(String slider_image) {
        this.slider_image = slider_image;
    }

    public String getSlider_video() {
        return slider_video;
    }

    public void setSlider_video(String slider_video) {
        this.slider_video = slider_video;
    }

    public String getSlider_backlink() {
        return slider_backlink;
    }

    public void setSlider_backlink(String slider_backlink) {
        this.slider_backlink = slider_backlink;
    }

    public String getSlider_date() {
        return slider_date;
    }

    public void setSlider_date(String slider_date) {
        this.slider_date = slider_date;
    }

    public String getSlider_status() {
        return slider_status;
    }

    public void setSlider_status(String slider_status) {
        this.slider_status = slider_status;
    }

    public String getSlider_note() {
        return slider_note;
    }

    public void setSlider_note(String slider_note) {
        this.slider_note = slider_note;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    

}
