/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yae.sakuya.mat_server.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.Stateless;
import yae.sakuya.mat_server.ConnectionFactory;
import yae.sakuya.mat_server.enteties.Rateing_img;

/**
 *
 * @author SakuayaYae
 */
@Stateless
public class Rateing_img_bean {
    private final String path = "./img/rateing/";
    private final String file_end = ".png";
    
    
     /**
     * function for retriving rateing images
     * @return A object of type Rateing_img containig the file path for rateing images or a empty object if an erreor happens
     */
    public Rateing_img get_img(){
        try(Connection con = ConnectionFactory.getconnection()){
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `rateing_img`");
            ResultSet result = stmt.executeQuery();
            result.next();
            
            String like = result.getString("like");
            like = path + like + file_end;
            String dislike = result.getString("dislike");
            dislike = path + dislike + file_end;
            
            return new Rateing_img(like, dislike);
        }
       catch(SQLException sql){
           System.out.println(sql.getMessage()+ ":: Rateing_bean");
       }
       catch(Exception e){
           System.out.println(e.getMessage()+ ":: Rateing_bean");
       }
        
       return new Rateing_img();
    }
}
