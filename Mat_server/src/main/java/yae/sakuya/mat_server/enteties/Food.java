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
public class Food {
    private String title;
    private String img_src;
    private String serving_date;
    private String rateing;
    private String ingrediens;
    private String week_day;

   
    public String getWeek_day() {
        return week_day;
    }

    public void setWeek_day(String week_day) {
        this.week_day = week_day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getServing_date() {
        return serving_date;
    }

    public void setServing_date(String serving_date) {
        this.serving_date = serving_date;
    }

    public String getRateing() {
        return rateing;
    }

    public void setRateing(String rateing) {
        this.rateing = rateing;
    }

    public String getIngrediens() {
        return ingrediens;
    }

    public void setIngrediens(String ingrediens) {
        this.ingrediens = ingrediens;
    }

     public Food(String title, String img_src, String serving_date, String rateing, String ingrediens, String week_day) {
        this.title = title;
        this.img_src = img_src;
        this.serving_date = serving_date;
        this.rateing = rateing;
        this.ingrediens = ingrediens;
        this.week_day = week_day;
    }


    public Food() {
    }
    
    
}
