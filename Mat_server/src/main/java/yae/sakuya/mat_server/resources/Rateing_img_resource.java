/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yae.sakuya.mat_server.resources;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import yae.sakuya.mat_server.beans.Rateing_img_bean;

/**
 *
 * @author SakuyaYae
 */
@Path("img")
public class Rateing_img_resource {
    @EJB
    Rateing_img_bean img;
    
    
     /**
     * function for Handleing GET requests
     * @return Status 200 and data form the database
     */
    @GET
    public Response get_img(){
        return Response.status(Response.Status.OK).entity(img.get_img()).build();
    }
}
