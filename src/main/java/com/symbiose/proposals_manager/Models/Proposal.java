package com.symbiose.proposals_manager.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@org.springframework.data.mongodb.core.mapping.Document
public class Proposal {
    @Id
    private String id;
    private String name;
    private String client_id;
    private List<String> tags;
    private int budget;
    private String description;

    public Proposal(String name, String client_id, List<String> tags, int budget, String description) {
        this.name = name;
        this.client_id = client_id;
        this.tags = tags;
        this.budget = budget;
        this.description = description;
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

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public List<String> getTags() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
