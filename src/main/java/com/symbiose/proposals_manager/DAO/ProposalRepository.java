package com.symbiose.proposals_manager.DAO;

import com.symbiose.proposals_manager.Models.Proposal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends MongoRepository<Proposal, String> {
    public Proposal findByName(String name);
}
