/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author admin
 */
public class ImgPerson {

    private String img_video_url;
    private String alt_text;

    public ImgPerson() {
    }

    public ImgPerson(String img_video_url, String alt_text) {
        this.img_video_url = img_video_url;
        this.alt_text = alt_text;
    }

    public String getImg_video_url() {
        return img_video_url;
    }

    public void setImg_video_url(String img_video_url) {
        this.img_video_url = img_video_url;
    }

    public String getAlt_text() {
        return alt_text;
    }

    public void setAlt_text(String alt_text) {
        this.alt_text = alt_text;
    }

    @Override
    public String toString() {
        return "ImgPerson{" + "img_video_url=" + img_video_url + ", alt_text=" + alt_text + '}';
    }

}
