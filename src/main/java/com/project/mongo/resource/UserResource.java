package com.project.mongo.resource;

import com.project.mongo.entity.User;
import com.project.mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;



@RestController
@RequestMapping("/api/users")
@Produces(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
public class UserResource {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST)
    public Response createUser(@RequestBody User user) {
        userService.save(user);
        return Response.ok().build();
    }

    // access http://localhost:9999/api/user/all
    @RequestMapping(method = RequestMethod.GET)
    public Response findAllUsers() {

        List<User> list = userService.findAll();
        return Response.ok().entity(list).type(MediaType.APPLICATION_JSON + ";charset=utf-8").build();
    }

    @RequestMapping(value ={"/id"} ,method = RequestMethod.DELETE)
    public Response deleteUser(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return Response.ok().build();
    }
}
