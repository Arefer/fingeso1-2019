package com.symbiose.proposals_manager.Controllers;

import com.symbiose.proposals_manager.DAO.ClientRepository;
import com.symbiose.proposals_manager.Models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    private ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository c){
        clientRepository = c;
    }

    // CREATE
    @RequestMapping(value = "/client/create", method = RequestMethod.POST)
    public @ResponseBody Client createClient(@RequestBody Client c){
        return clientRepository.save(c);
    }
}
