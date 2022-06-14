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
public class Rateing_img {
    private String like;
    private String dislike;

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getDislike() {
        return dislike;
    }

    public void setDislike(String dislike) {
        this.dislike = dislike;
    }

    public Rateing_img(String like, String dislike) {
        this.like = like;
        this.dislike = dislike;
    }

    public Rateing_img() {
    }
    
    
}
