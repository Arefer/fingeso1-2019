package com.symbiose.proposals_manager.proposal_manager.DAO;

import com.symbiose.proposals_manager.proposal_manager.Models.Proposal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends MongoRepository<Proposal, String> {
    public Proposal findByName(String name);
    @Query("{ 'client_id' : ?0 }")
    public List<Proposal> findByClient_id(String client_id);

    @Query(value="{client_id : ?0}", delete = true)
    public List<Proposal> deleteByClient_id(String client_id);

}
