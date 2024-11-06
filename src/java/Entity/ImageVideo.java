/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author admin
 */
public class ImageVideo {
   private int img_video_id;
   private int ProductID;
   private String img_video_url;
   private String alt_text;

    public ImageVideo( int ProductID,int img_video_id, String img_video_url, String alt_text) {
        this.img_video_id = img_video_id;
        this.ProductID = ProductID;
        this.img_video_url = img_video_url;
        this.alt_text = alt_text;
    }

    public ImageVideo() {
    }

    public int getImg_video_id() {
        return img_video_id;
    }

    public void setImg_video_id(int img_video_id) {
        this.img_video_id = img_video_id;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
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
        return "ImageVideo{" + "img_video_id=" + img_video_id + ", ProductID=" + ProductID + ", img_video_url=" + img_video_url + ", alt_text=" + alt_text + '}';
    }
   
}
