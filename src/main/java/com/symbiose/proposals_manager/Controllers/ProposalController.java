package com.symbiose.proposals_manager.Controllers;

import com.symbiose.proposals_manager.Models.Proposal;
import com.symbiose.proposals_manager.Services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProposalController {
    @Autowired
    private ProposalService proposalService;

    @RequestMapping("/proposal/create")
    public String createProposal(@RequestParam String name, @RequestParam int client_id, @RequestParam int budget){
        Proposal p = proposalService.create(name, client_id, budget);
        return p.toString();
    }

    @RequestMapping("proposal/getall")
    public List<Proposal> getAllProposals(){
        return proposalService.getAll();
    }
}
