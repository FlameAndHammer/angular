package com.nikulin.testtask.web;

import com.nikulin.testtask.server.model.entity.User;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.nikulin.testtask.server.service.BasicUserService;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * Created by Александр on 17.10.2015.
 */
@Controller
public class UserServiceController {

    private static Logger LOG = Logger.getLogger(UserServiceController.class);
    @Resource
    private BasicUserService basicUserService;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
     public String welcomeHandleRequest(ModelMap model, Principal principal) {
        LOG.trace("Enter welcome page");
        if ((principal != null) && (((UsernamePasswordAuthenticationToken)principal).isAuthenticated())){
            return "helloworld";
        }
        else {
            return "login";
        }
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminHandleRequest(ModelAndView model, Principal principal) {
        LOG.trace("Enter admin page");
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");
        return "admin";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginHandle1Request() {
        LOG.trace("Enter index page");
        return "login";
    }
    @RequestMapping(value = "/create_user", method = RequestMethod.GET)
    public String createUserPageHandle1Request() {
        LOG.trace("Enter create user page");
        return "create_user";
    }
    @RequestMapping(value = "/check_password", method = RequestMethod.GET)
    public @ResponseBody String checkPasswordPageHandle1Request(@RequestParam(value = "password", required = false) String password) {
        LOG.trace("Enter check password page");
        return String.valueOf(basicUserService.checkPassword(password));
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUserHandle1Request(@RequestParam(value = "username", required = false) String username,
                                           @RequestParam(value = "password", required = false) String password) {
        LOG.trace("Enter create_user page");
        basicUserService.createUser(username,password);
        return "redirect:login?newUser";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              @RequestParam(value = "newUser", required = false) String newUser) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }

        if (newUser != null) {
            model.addObject("msg", "New user was created.");
        }
        model.setViewName("login");

        return model;

    }
}
