/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author admin
 */
public class videoComment {
   private int video_id;
   private int PersonID;
   private String video_url;
   private String alt_text;

    public videoComment() {
    }

    public videoComment(int video_id,String img_video_url, String alt_text) {
        this.video_id = video_id;
        this.PersonID = PersonID;
        this.video_url = img_video_url;
        this.alt_text = alt_text;
    }

  

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public String getImg_video_url() {
        return video_url;
    }

    public void setImg_video_url(String img_video_url) {
        this.video_url = img_video_url;
    }

    public String getAlt_text() {
        return alt_text;
    }

    public void setAlt_text(String alt_text) {
        this.alt_text = alt_text;
    }

    @Override
    public String toString() {
        return "videoComment{" + "video_id=" + video_id + ", PersonID=" + PersonID + ", video_url=" + video_url + ", alt_text=" + alt_text + '}';
    }
}
