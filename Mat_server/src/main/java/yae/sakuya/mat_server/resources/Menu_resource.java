/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yae.sakuya.mat_server.resources;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import yae.sakuya.mat_server.beans.Food_bean;
import yae.sakuya.mat_server.beans.User_bean;
import yae.sakuya.mat_server.enteties.Food;
import yae.sakuya.mat_server.enteties.Order;
import yae.sakuya.mat_server.enteties.Users;

/**
 *
 * @author SakuyaYae
 */
@Path("menu")
public class Menu_resource {
    @EJB
    Food_bean food_bean;
    
    @EJB
    User_bean user_bean;
    
    /**
     * function for Handleing GET requests
     * @param authorization
     * @return Status 204 if the is nonting to get from the database or 200 and data form the database if the where data in the database or 401 if user dose not exist
     */
    @GET
    public Response get_menu(@HeaderParam("Authorization") String authorization){
        if(authorization == null){
                return Response.status(Response.Status.UNAUTHORIZED).build();        
        }
        else{
            Users user = user_bean.create_user(authorization);
            List<Food> menu = food_bean.get_list_of_food(user);
            if(menu.size() > 0){
                return Response.status(Response.Status.OK).entity(menu).build();
            }
            else{
                return Response.status(Response.Status.NO_CONTENT).build();
            }
        }

    }
}
