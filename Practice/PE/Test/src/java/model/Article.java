/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nguye
 */
public class Article {
    public String id, title,created_date,created_by;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreated_date() {
        return created_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Article() {
    }

    public Article(String id, String title, String created_date, String created_by) {
        this.id = id;
        this.title = title;
        this.created_date = created_date;
        this.created_by = created_by;
    }
    
    
    
}
