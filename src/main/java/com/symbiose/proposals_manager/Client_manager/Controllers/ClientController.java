package com.symbiose.proposals_manager.Client_manager.Controllers;

import com.symbiose.proposals_manager.Client_manager.DAO.ClientRepository;
import com.symbiose.proposals_manager.Client_manager.Models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ClientController {
    private ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    // CREATE
    @RequestMapping(value = "/client/create", method = RequestMethod.POST)
    public @ResponseBody Client createClient(@RequestBody Client c){
        return clientRepository.save(c);
    }

    //READ
    @RequestMapping(value = "/client/get", method = RequestMethod.GET)
    public @ResponseBody Client getClient(@RequestParam String Client_id){
        Optional c = clientRepository.findById(Client_id);
        Client cliente = new Client("0", "0", "0", "0", "0");
        if (c.isPresent()){
            return (Client)c.get();
        }
        return cliente;
    }

    @RequestMapping(value="client/getall", method = RequestMethod.GET)
    public @ResponseBody List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    //UPDATE

    @RequestMapping(value = "/client/update", method = RequestMethod.POST)
    public @ResponseBody Client updateClient (@RequestBody Client client){
        return clientRepository.save(client);

    }

    // Delete
    @RequestMapping(value="/client/delete", method = RequestMethod.GET)
    public String deleteClient(@RequestParam String client_id){
        Optional c = clientRepository.findById(client_id);
        if (c.isPresent()){
            clientRepository.delete((Client)c.get());
            return "Cliente eliminado";
        } else {
            return "NO EXISTE!";
        }
    }
}
