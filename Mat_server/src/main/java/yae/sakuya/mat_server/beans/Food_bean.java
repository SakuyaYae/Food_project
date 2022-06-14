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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import yae.sakuya.mat_server.ConnectionFactory;
import yae.sakuya.mat_server.enteties.Food;
import yae.sakuya.mat_server.enteties.Order;
import yae.sakuya.mat_server.enteties.Rateing;
import yae.sakuya.mat_server.enteties.Users;

/**
 * 
 * @author SakuyaYae
 */
@Stateless
public class Food_bean {
    private final String path = "./img/";
    
    /**
     * Function for geting a List of dishes from the database 
     * @param user
     * @return ArrayList
     */
    public List<Food> get_list_of_food(Users user){
        List<Food> food_list = new ArrayList<>();
        try(Connection con = ConnectionFactory.getconnection()){
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `food`");
            ResultSet result = stmt.executeQuery();
    
            while(result.next()){
                    String title = result.getString("title");
                    String img_src = result.getString("img_src");
                    img_src = path + img_src;
                    String serving_date = result.getString("serving_date");
                    Rateing rate = get_food_rating(user, title);
                    String rateing = rate.getRateing(); 
                    String ingredients = result.getString("ingredients");
                    String week_day = result.getString("week_day");
                    
                    
                    Food food = new Food(title, img_src, serving_date, rateing, ingredients, week_day);
                    
                    food_list.add(food);
            }
            
            
        }
        catch(SQLException sql){
            System.out.println(sql.getMessage() + ": Food_bean sql (get_list_of_food)");
        }
        
        catch(Exception e){
            System.out.println(e.getMessage() + ": Food_bean (get_list_of_food)");
        }
        return food_list;
    
    }
    
    /**
     * Function for geting a List of orders of a user from the database
     * @param user
     * @return ArrayList
     */
    public List<Order> get_list_of_orders(Users user){
        List<Order> food_list = new ArrayList<>();
        try(Connection con = ConnectionFactory.getconnection()){
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `orders` WHERE username = ?");
            stmt.setString(1, user.getUsername());
            ResultSet result = stmt.executeQuery();
            
            while(result.next()){
                    String title = result.getString("title");
                    String img_src = result.getString("img_src");
                    img_src = path + img_src;
                    String serving_date = result.getString("serving_date");
                    
                    Rateing rate = get_food_rating(user, title);
                    String rateing = rate.getRateing();
                    
                    String ingredients = result.getString("ingredients");
                    String username = user.getUsername();
                    String week_day = result.getString("week_day");
                    
                    
                    Order food = new Order(title, img_src, serving_date, rateing, ingredients, username, week_day);
                    
                    food_list.add(food);
            }
            
            
        }
        catch(SQLException sql){
            System.out.println(sql.getMessage() + ": Food_bean sql (get_list_of_orders)");
        }
        
        catch(Exception e){
            System.out.println(e.getMessage() + ": Food_bean (get_list_of_orders)");
        }
        return food_list;
    
    }
    
    /**
     * Function for geting the rateing on a dish from a specific user from the database
     * @param user
     * @param name
     * @return Rating obj containing a title, username and a rateing
     */
    public Rateing get_food_rating(Users user, String name){
            String title = name;
            String username = user.getUsername();
            
        try(Connection con = ConnectionFactory.getconnection()){
            PreparedStatement ps = con.prepareStatement("SELECT rateing FROM rating WHERE username = ? AND title = ?");
            ps.setString(1, user.getUsername());
            ps.setString(2, name);
            ResultSet res = ps.executeQuery();
            res.next();
            
            String score = res.getString("rateing");
            Rateing rateing = new Rateing(title, score, username);
            
            return rateing;
        }
        catch(SQLException sql){
            System.out.println(sql.getMessage() + ": Food_bean (get_food_rateing)");
        }
        
        catch(Exception e){
            System.out.println(e.getMessage() + ": food_bean (get_food_rateing)");
        }
        return new Rateing(title, "0", username);
    }
    
    /**
     * Function for stroreing a Order in the database
     * @param user
     * @param order
     * @return wether the order was stored or not
     */
    public boolean post_order_food(Users user, Food order){
        boolean success = false;
        Rateing rate = get_food_rating(user, order.getTitle());
        String img_src[] = order.getImg_src().split(path);
        
        try(Connection con = ConnectionFactory.getconnection()){
                PreparedStatement stmt = con.prepareStatement("INSERT INTO orders(title, rateing, img_src, ingredients, username, serving_date, week_day) VALUES(?, ?, ?, ?, ?, ?, ?)");
                stmt.setString(1, order.getTitle());
                stmt.setString(2, rate.getRateing()); 
                stmt.setString(3, img_src[1]);
                stmt.setString(4, order.getIngrediens());
                stmt.setString(5, user.getUsername());
                stmt.setString(6, order.getServing_date());
                stmt.setString(7, order.getWeek_day());
                success = stmt.executeUpdate() > 0;
        
        }
        catch(SQLException sql){
            System.out.println(sql.getMessage() + ": Food_bean sql (post_order_food)");
        }
        
        catch(Exception e){
            System.out.println(e.getMessage() + ": Food_bean (post_order_food)");
        }
        return success;
    }
}
