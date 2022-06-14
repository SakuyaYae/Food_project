/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yae.sakuya.mat_server.resources;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import yae.sakuya.mat_server.beans.Rateing_bean;
import yae.sakuya.mat_server.beans.User_bean;
import yae.sakuya.mat_server.enteties.Rateing;
import yae.sakuya.mat_server.enteties.Users;

/**
 *
 * @author SakuyaYae
 */
@Path("/rateing")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Rateing_resource {
    @EJB
    User_bean user_bean;
    
    @EJB
    Rateing_bean rate;
    
    /**
     * Function for handeling POST requests
     * @param authorization
     * @param rateing
     * @return Status 401 if user dose not exist in the database, 201 if the rateing was stored successfully or 400 if the data sent was wrong
     */
    @POST
    public Response post_rateing(@HeaderParam("Authorization") String authorization, Rateing rateing){
        if(authorization == null){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        else{
            Users user = user_bean.create_user(authorization);
            if(user_bean.check_user(user)){
                if(rate.post_food_rateing(rateing, user)){
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
