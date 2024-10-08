/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.*;
import java.lang.*;

public class Blog {

    private int blogID;
    private String blog_img;
    private String blog_img_tittle;
    private String blog_tittle;
    private String blog_type;
    private String blog_summary_information;
    private Date blog_update_time;
    private String blog_detail;
    private int blog_views;
    private String blog_status;
    private int blog_flag;

    private Person person;

    public Blog() {
    }

    public Blog(int blogID, String blog_img, String blog_img_tittle, String blog_tittle, String blog_type, String blog_summary_information, Date blog_update_time, String blog_detail, int blog_views, String blog_status, int blog_flag, Person person) {
        this.blogID = blogID;
        this.blog_img = blog_img;
        this.blog_img_tittle = blog_img_tittle;
        this.blog_tittle = blog_tittle;
        this.blog_type = blog_type;
        this.blog_summary_information = blog_summary_information;
        this.blog_update_time = blog_update_time;
        this.blog_detail = blog_detail;
        this.blog_views = blog_views;
        this.blog_status = blog_status;
        this.blog_flag = blog_flag;
        this.person = person;
    }

    public String getBlog_img_tittle() {
        return blog_img_tittle;
    }

    public void setBlog_img_tittle(String blog_img_tittle) {
        this.blog_img_tittle = blog_img_tittle;
    }

    public int getBlog_flag() {
        return blog_flag;
    }

    public void setBlog_flag(int blog_flag) {
        this.blog_flag = blog_flag;
    }

   

    public int getBlogID() {
        return blogID;
    }

    public String getBlog_img() {
        return blog_img;
    }

    public String getBlog_tittle() {
        return blog_tittle;
    }

    public String getBlog_summary_information() {
        return blog_summary_information;
    }

    public Date getBlog_update_time() {
        return blog_update_time;
    }

    public String getBlog_detail() {
        return blog_detail;
    }

    public String getBlog_type() {
        return blog_type;
    }

    public String getBlog_status() {
        return blog_status;
    }

    public Person getPerson() {
        return person;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }

    public void setBlog_img(String blog_img) {
        this.blog_img = blog_img;
    }

    public int getBlog_views() {
        return blog_views;
    }

    public void setBlog_tittle(String blog_tittle) {
        this.blog_tittle = blog_tittle;
    }

    public void setBlog_summary_information(String blog_summary_information) {
        this.blog_summary_information = blog_summary_information;
    }

    public void setBlog_update_time(Date blog_update_time) {
        this.blog_update_time = blog_update_time;
    }

    public void setBlog_detail(String blog_detail) {
        this.blog_detail = blog_detail;
    }

    public void setBlog_status(String blog_status) {
        this.blog_status = blog_status;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setBlog_type(String blog_type) {
        this.blog_type = blog_type;
    }

    public void setBlog_views(int blog_views) {
        this.blog_views = blog_views;
    }

}
