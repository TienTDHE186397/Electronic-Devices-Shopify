/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CommentPerson {

    private int commentid;
    private int productid;
    private Person person;
    private String content;
    private LocalDate createAt;
    private List<String> imageUrls = new ArrayList<>();
    private List<String> videoUrls = new ArrayList<>();
    private List<String> imageText = new ArrayList<>();
    private List<String> videoText = new ArrayList<>();

    public CommentPerson() {
    }

    public List<String> getImageText() {
        return imageText;
    }

    public void setImageText(List<String> imageText) {
        this.imageText = imageText;
    }

    public List<String> getVideoText() {
        return videoText;
    }

    public void setVideoText(List<String> videoText) {
        this.videoText = videoText;
    }

    public CommentPerson(int commentid, int productid, Person person, String content, LocalDate createAt) {
        this.commentid = commentid;
        this.productid = productid;
        this.person = person;
        this.content = content;
        this.createAt = createAt;
    }

    public void addImageText(String imgText) {
        this.imageText.add(imgText);
    }

    public void addVideoText(String videoText) {
        this.videoText.add(videoText);
    }

    public void addImageUrl(String imageUrl) {
        this.imageUrls.add(imageUrl);
    }

    public void addVideoUrl(String videoUrl) {
        this.videoUrls.add(videoUrl);
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public List<String> getVideoUrls() {
        return videoUrls;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public int getProduct() {
        return productid;
    }

    public void setProduct(int product) {
        this.productid = product;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "CommentPerson{" + "commentid=" + commentid + ", productid=" + productid + ", person=" + person + ", "
                + "content=" + content + ", createAt=" + createAt + ", imageUrls=" + imageUrls + ", videoUrls=" + videoUrls + '}';
    }

}
