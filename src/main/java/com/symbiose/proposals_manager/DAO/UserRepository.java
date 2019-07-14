package com.symbiose.proposals_manager.DAO;


import com.symbiose.proposals_manager.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
