/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yae.sakuya.mat_server.resources;



import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import yae.sakuya.mat_server.beans.Food_bean;
import yae.sakuya.mat_server.beans.User_bean;
import yae.sakuya.mat_server.enteties.Food;
import yae.sakuya.mat_server.enteties.Order;
import yae.sakuya.mat_server.enteties.Users;

/**
 *
 * @author SakuyaYae
 */

@Path("/food")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Food_resource {
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
    public Response get_orders(@HeaderParam("Authorization") String authorization){
        if(authorization == null){
                return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        else{
            Users user = user_bean.create_user(authorization);
            List<Order> orders = food_bean.get_list_of_orders(user);
           
            if(orders.size() > 0){
                return Response.status(Response.Status.OK).entity(orders).build();
            }
            else{
                return Response.status(Response.Status.NO_CONTENT).build();
            }
        }

    }
   
    /**
     * function for Handleing POST requests
     * @param authorization
     * @param food
     * @return Status 401 if user dose not exist in the database, 201 if the Order was stored successfully or 400 if the data sent was wrong
     */
    @POST
    public Response post_order(@HeaderParam("Authorization") String authorization , Food food){
        if(authorization == null){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        else{
            Users user = user_bean.create_user(authorization); 
            if(user_bean.check_user(user)){              
                if(food_bean.post_order_food(user, food)){
                    return Response.status(Response.Status.CREATED).build();
                }
                else{
                    return Response.status(Response.Status.BAD_REQUEST).build();
                }
            }
            else{
                return Response.status(Response.Status.UNAUTHORIZED).build();
            } 
        }
    }
}
