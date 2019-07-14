package com.symbiose.proposals_manager.Models;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class File {
    private int id;
    private String type; // Administrativo, tecnico, otro, etc.
    private String fileName;
    private String extension;
    private Binary file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Binary getFile() {
        return file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFile(Binary file) {
        this.file = file;
    }
}
