package com.symbiose.proposals_manager.DAO;


import com.symbiose.proposals_manager.Models.File;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<File, String> {

}
