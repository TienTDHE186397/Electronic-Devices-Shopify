/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Entity;


import java.util.*;
import java.lang.*;







public class CommentBlog {
    
    
    private int comment_id;
    private String comment_text;
    private String comment_date;
    private Person person;
    private Blog blog;

    public CommentBlog() {
    }

    public CommentBlog(int comment_id, String comment_text, String comment_date, Person person, Blog blog) {
        this.comment_id = comment_id;
        this.comment_text = comment_text;
        this.comment_date = comment_date;
        this.person = person;
        this.blog = blog;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }



}
