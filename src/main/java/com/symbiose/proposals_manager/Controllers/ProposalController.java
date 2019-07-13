package com.symbiose.proposals_manager.Controllers;

import com.symbiose.proposals_manager.DAO.ProposalRepository;
import com.symbiose.proposals_manager.Models.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProposalController {
    //@Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    public ProposalController(ProposalRepository proposalRepository)
    {
        this.proposalRepository = proposalRepository;
    }

    @RequestMapping("/proposal/create")
    public @ResponseBody Proposal createProposal(@RequestParam String name, @RequestParam String client_id, @RequestParam List<String> tags, @RequestParam int budget, @RequestParam String description){
        Proposal p = proposalRepository.save(new Proposal(name, client_id, tags, budget, description));
        return p;
    }

    // Create
    @RequestMapping(value="/proposal/create", method = RequestMethod.POST)
    public @ResponseBody Proposal createProposal(@RequestBody Proposal p){
        return proposalRepository.save(p);
    }

    // Read
    @RequestMapping(value="/proposal/get", method=RequestMethod.GET)
    public @ResponseBody Proposal getProposal(@RequestParam String proposal_id){
        Optional p = proposalRepository.findById(proposal_id);
        proposalRepository.save((Proposal)p.get());
        return (Proposal)p.get();
    }

    // Update

    // Delete
    @RequestMapping(value="proposal/delete", method = RequestMethod.GET)
    public String deleteProposal(@RequestParam String id){
        Optional p = proposalRepository.findById(id);
        if (p.isPresent()){
            proposalRepository.delete((Proposal)p.get());
            return "Propuesta eliminada";
        } else {
            return "NO EXISTE!";
        }
    }

    @RequestMapping("proposal/getall")
    public List<Proposal> getAllProposals(){
        return proposalRepository.findAll();
    }
}
