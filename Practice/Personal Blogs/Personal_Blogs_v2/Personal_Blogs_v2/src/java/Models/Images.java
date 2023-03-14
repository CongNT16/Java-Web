/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Images {
    
    private String post_id;
    private String img_filename;

    public String getPost_id() {
        return post_id;
    }

    public String getImg_filename() {
        return img_filename;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public void setImg_filename(String img_filename) {
        this.img_filename = img_filename;
    }

    public Images() {
    }

    public Images(String post_id, String img_filename) {
        this.post_id = post_id;
        this.img_filename = img_filename;
    }
    
    
    
}
