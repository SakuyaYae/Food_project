/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yae.sakuya.mat_server.resources;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import yae.sakuya.mat_server.beans.User_bean;
import yae.sakuya.mat_server.enteties.Users;

/**
 *
 * @author SakuyaYae
 */
@Path("user")
public class User_resource {
    @EJB
    User_bean user_bean;
    
    /**
     *
     * @param authorization
     * @return Status 401 if user dose not exists in the database or if authorization header is empty or 200 if user exist in the databse
     */
    @GET
    public Response check_user(@HeaderParam("Authorization") String authorization){
        if(authorization == null){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        Users user = user_bean.create_user(authorization);
        if(user_bean.check_user(user)){
            return Response.status(Response.Status.OK).build();
        }
        else{
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
    
    
}
