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
import yae.sakuya.mat_server.enteties.Users;

/**
 *
 * @author SakuyaYae
 */
@Stateless
public class User_bean {

    /**
     * 
     * @param user_data
     * @return A User obj
     */
    public Users create_user(String user_data){
        
        int user_data_separetor = user_data.indexOf(".");
        String username = user_data.substring(0, user_data_separetor);
        String password = user_data.substring(user_data_separetor + 1);
       
        return new Users(username, password);
    }
    
    /**
     * Function for validating if user exists in the database
     * @param user
     * @return Wether user is valid or not
     */
    public boolean check_user(Users user){
        boolean check = false;
        try(Connection con = ConnectionFactory.getconnection()){
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                check = true; 
            }
        }
        catch(SQLException sql){
            System.out.println(sql.getMessage() + ": checkuser sql error");
        }
        catch(Exception e){
            System.out.println(e.getMessage() + ": check_user other error");
        }
        return check;
    }
}
