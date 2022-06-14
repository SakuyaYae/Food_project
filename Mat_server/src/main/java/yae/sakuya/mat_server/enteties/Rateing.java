/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yae.sakuya.mat_server.enteties;

/**
 *
 * @author SakuyaYae
 */
public class Rateing {
    private String title;
    private String rateing;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRateing() {
        return rateing;
    }

    public void setRateing(String rateing) {
        this.rateing = rateing;
    }

    public Rateing(String title, String rateing, String username) {
        this.title = title;
        this.rateing = rateing;
        this.username = username;
    }

    public Rateing() {
    }
    
}
