package com.symbiose.proposals_manager.Controllers;

import com.symbiose.proposals_manager.DAO.ClientRepository;
import com.symbiose.proposals_manager.Models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    //@Autowired
    private ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    /*
    Create a new client
     */
    @RequestMapping(value="/client/create", method = RequestMethod.POST)
    public @ResponseBody
    Client createClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @RequestMapping("client/get_all")
    public List<Client> getAllProposals(){
        return clientRepository.findAll();
    }
}
