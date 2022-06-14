/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yae.sakuya.mat_server.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.ejb.Stateless;
import yae.sakuya.mat_server.ConnectionFactory;
import yae.sakuya.mat_server.enteties.Rateing;
import yae.sakuya.mat_server.enteties.Users;

/**
 *
 * @author SakuyaYae
 */
@Stateless
public class Rateing_bean {
    
    /**
     * function for storing rateing of dishes in the database
     * @param rateing
     * @param user
     * @return true or false based on the success of the Update of the database table
     */
    public boolean post_food_rateing(Rateing rateing, Users user){
        boolean success = false;
        System.out.println(rateing.getRateing() + " " + rateing.getTitle() + " //");
        try(Connection con = ConnectionFactory.getconnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO rating(title, username, rateing) VALUES(?, ?, ?)");
            ps.setString(1, rateing.getTitle());
            ps.setString(2, user.getUsername());
            ps.setString(3, rateing.getRateing());
            success = ps.executeUpdate() > 0;
            
        
        }
        catch(SQLException sql){
            System.out.println(sql.getMessage() + ": Rateing_bean sql (post_food_rateing)");
        }
        
        catch(Exception e){
            System.out.println(e.getMessage() + ": Rateing_bean (post_food_rateing)");
        }
        return success;
    }
}
