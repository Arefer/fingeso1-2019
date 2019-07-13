package com.symbiose.proposals_manager.DAO;

import com.symbiose.proposals_manager.Models.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    public Client findByName(String name);
}

