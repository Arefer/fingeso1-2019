package com.symbiose.proposals_manager.Controllers;

import com.symbiose.proposals_manager.DAO.FileRepository;
import com.symbiose.proposals_manager.Models.File;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class FileController {
    @Autowired
    FileRepository fileRepository;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;

    @RequestMapping(value="/file/upload", method = RequestMethod.POST)
    public String createFile(@RequestParam("file") MultipartFile f) throws IOException {
        File newFile = new File();
        newFile.setFile(new Binary(BsonBinarySubType.BINARY, f.getBytes()));

        return fileRepository.insert(newFile).getId();
    }

    @RequestMapping(value="/file/retrieve", method=RequestMethod.GET)
    public byte[] retrieveFile(@RequestParam("id") String id) throws IOException {
        File file = fileRepository.findById(id).get();

        Path path = Paths.get("asdsadasd.c");

        java.nio.file.Files.write(path, file.getFile().getData());

        return file.getFile().getData();
    }

    @RequestMapping(value="/file/getall", method=RequestMethod.GET)
    public @ResponseBody List<File> getAllFiles(){
        List<File> files = fileRepository.findAll();
        return files;
    }
}
