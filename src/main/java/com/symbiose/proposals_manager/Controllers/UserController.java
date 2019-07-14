package com.symbiose.proposals_manager.Controllers;


import com.symbiose.proposals_manager.DAO.UserRepository;
import com.symbiose.proposals_manager.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.Optional;

@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //CREATE
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public @ResponseBody User createUser(@RequestBody User u){
        return userRepository.save(u);
    }

    //UPDATE
    @RequestMapping (value = "/user/update", method = RequestMethod.GET)
    public @ResponseBody User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }

    //READ
    @RequestMapping (value = "/user/get", method = RequestMethod.GET)
    public @ResponseBody User getUser(@RequestParam String User_id){
        Optional u = userRepository.findById(User_id);
        User usuario = new User("0", "9", "0", "0");
        if (u.isPresent()){
            return (User)u.get();
        }
        return usuario;
    }

    //DELETE

    @RequestMapping (value = "user/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam String User_id){
        Optional u = userRepository.findById(User_id);
        if (u.isPresent()){
            userRepository.delete((User)u.get());
            return "USUARIO ELIMINADO";
        } else {
            return "NO EXISTE!";
        }
    }
}
