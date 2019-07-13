package com.symbiose.proposals_manager.Controllers;

import com.symbiose.proposals_manager.DAO.ProposalRepository;
import com.symbiose.proposals_manager.Models.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProposalController {
    @Autowired
    private ProposalRepository proposalRepository;

    @RequestMapping("/proposal/create")
    public String createProposal(@RequestParam String name, @RequestParam int client_id, @RequestParam int budget){
        //Proposal p = proposalService.create(name, client_id, budget);
        Proposal p = proposalRepository.save(new Proposal(name, client_id, budget));
        return p.toString();
    }

    @RequestMapping("proposal/getall")
    public List<Proposal> getAllProposals(){
        return proposalRepository.findAll();
    }
}
