package com.symbiose.proposals_manager.Services;

import com.symbiose.proposals_manager.DAO.ProposalRepository;
import com.symbiose.proposals_manager.Models.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalService {
    @Autowired
    ProposalRepository proposalRepository;

    public Proposal create(String name, int client_id, int budget){
        return proposalRepository.save(new Proposal(name, client_id, budget));
    }

    public Proposal getByName(String name){
        return proposalRepository.findByName(name);
    }

    public List<Proposal> getAll(){
        return proposalRepository.findAll();
    }

    public void delete(String name){
        Proposal p = proposalRepository.findByName(name);
        proposalRepository.delete(p);
    }
}
