/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Vũ Đức Hải
 */
public class PersonImage {
    private int image_id;
    private Person person;
    private String image_url;
    private String alt_text;

    public PersonImage() {
    }

    public PersonImage(int image_id, Person person, String image_url, String alt_text) {
        this.image_id = image_id;
        this.person = person;
        this.image_url = image_url;
        this.alt_text = alt_text;
    }

    public int getImage_id() {
        return image_id;
    }

    public Person getPerson() {
        return person;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getAlt_text() {
        return alt_text;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setAlt_text(String alt_text) {
        this.alt_text = alt_text;
    }

    @Override
    public String toString() {
        return "PersonImage{" + "image_id=" + image_id + ", person=" + person + ", image_url=" + image_url + ", alt_text=" + alt_text + '}';
    } 
}
