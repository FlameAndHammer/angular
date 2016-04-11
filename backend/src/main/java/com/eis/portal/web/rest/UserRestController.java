/*
package com.eis.portal.web.rest;

import java.util.List;
import com.google.inject.Inject;
import com.eis.portal.model.entity.User;
import com.eis.portal.service.BasicUserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

*/
/**
 * Created by Александр on 09.04.2016.
 *//*


@Path("/users")
public class UserRestController {

    private final BasicUserService userService;

    @Inject
    public UserRestService(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("numberOfUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public int getNumberOfUsers() {
        return userService.getNumberOfUsers();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsersInJSON() {
        return userService.getAllUsers();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") int id) {
        return userService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User create(User user) {
        return userService.createNewUser(user);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User update(User user) {
        return userService.update(user);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") int id) {
        userService.remove(id);
    }
}

*/
