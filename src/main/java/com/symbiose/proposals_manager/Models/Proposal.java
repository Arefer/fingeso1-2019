package com.symbiose.proposals_manager.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@org.springframework.data.mongodb.core.mapping.Document
public class Proposal {
    @Id
    String id;
    String name;
    int client_id;
    ArrayList<String> tags;
    int budget;

    public Proposal(String name, int client_id, int budget) {
        this.name = name;
        this.client_id = client_id;
        this.budget = budget;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Proposal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", client_id=" + client_id +
                ", tags=" + tags +
                ", budget=" + budget +
                '}';
    }
}
