package com.symbiose.proposals_manager.Controllers;

import com.symbiose.proposals_manager.DAO.ProposalRepository;
import com.symbiose.proposals_manager.Models.File;
import com.symbiose.proposals_manager.Models.Proposal;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ProposalController {
    //@Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    public ProposalController(ProposalRepository proposalRepository)
    {
        this.proposalRepository = proposalRepository;
    }

    // Create
    @RequestMapping(value="/proposal/create", method = RequestMethod.POST)
    public @ResponseBody Proposal createProposal(@RequestBody Proposal p){
        return proposalRepository.save(p);
    }

    // Read
    @RequestMapping(value="/proposal/get", method=RequestMethod.GET)
    public @ResponseBody Proposal getProposal(@RequestParam String proposal_id){
        Optional p = proposalRepository.findById(proposal_id);
        proposalRepository.save((Proposal)p.get());
        return (Proposal)p.get();
    }

    @RequestMapping("proposal/getall")
    public List<Proposal> getAllProposals(){
        return proposalRepository.findAll();
    }

    // Update
    // Actualiza todos los campos excepto la lista de archivos
    @RequestMapping(value="proposal/edit", method = RequestMethod.POST)
    public @ResponseBody Proposal editProposal(@RequestBody Proposal p){
        Optional oProposal = proposalRepository.findById(p.getId());
        if (!oProposal.isPresent()) return null;
        p.setAsociatedFiles(((Proposal)oProposal.get()).getAsociatedFiles());
        return proposalRepository.save(p);
    }
    // Delete
    @RequestMapping(value="/proposal/delete", method = RequestMethod.GET)
    public String deleteProposal(@RequestParam String id){
        Optional p = proposalRepository.findById(id);
        if (p.isPresent()){
            proposalRepository.delete((Proposal)p.get());
            return "Propuesta eliminada";
        } else {
            return "NO EXISTE!";
        }
    }

    // Asocia un documento a la propuesta
    @RequestMapping(value="/proposal/attachFile", method=RequestMethod.POST)
    public File attachFile(@RequestParam("id") String id, @RequestParam("file") MultipartFile file, @RequestParam("fileType") String fileType){
        // Busca la propuesta para asociarle el archivo
        Optional oProposal = proposalRepository.findById(id);
        if (oProposal.isPresent()){
            // Extrar el nombre y extension del archivo
            String fileFullName = file.getOriginalFilename();
            String[] splittedName = fileFullName.split("\\.");
            File newFile = new File();
            newFile.setType(fileType);
            try {
                newFile.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
                newFile.setFileName(splittedName[0]);
                newFile.setExtension(splittedName[1]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Proposal p = (Proposal)oProposal.get();
            if (p.getAsociatedFiles() == null){
                newFile.setId(1);
                p.setAsociatedFiles(Arrays.asList(newFile));
            } else {
                File lastFile = p.getAsociatedFiles().get(p.getAsociatedFiles().size()-1);
                newFile.setId(lastFile.getId()+1);
                List<File> fileList = p.getAsociatedFiles();
                fileList.add(newFile);
                p.setAsociatedFiles(fileList);
            }
            proposalRepository.save(p);
            return newFile;

        } else {
            return null;
        }
    }

    /*// Asocia multiples documentos a la propuesta
    @RequestMapping(value="/proposal/attachMultipleFiles", method=RequestMethod.POST)
    public List<File> attachMultipleFiles(@RequestParam("id") String id, @RequestParam("files") List<MultipartFile> files){
        // Busca la propuesta
        Optional oProposal = proposalRepository.findById(id);
        if (!oProposal.isPresent()) return null;

    }*/

    // Elimina un documento asociado a una propuesta
    @RequestMapping(value="/proposal/deleteFile", method=RequestMethod.GET)
    public String deleteFile(@RequestParam("proposal_id") String proposal_id, @RequestParam("file_id") int file_id){
        // Busca la propuesta
        Optional oProposal = proposalRepository.findById(proposal_id);
        if (!oProposal.isPresent()) return "ERROR: La propuesta no existe";
        Proposal p = (Proposal)oProposal.get();
        if (p.deleteFile(file_id)) {
            proposalRepository.save(p);
            return "Documento eliminado";
        }
        else return "ERROR: El documento no existe";
    }

    // Descarga un documento asociado a la propuesta
    @RequestMapping(value="proposal/downloadFile", method=RequestMethod.GET)
    public byte[] downloadAssociatedFile(@RequestParam("proposal_id") String proposal_id, @RequestParam("file_id") int file_id) throws IOException {
        // Buscamos la propuesta
        Optional oProposal = proposalRepository.findById(proposal_id);
        if (oProposal.isPresent()){
            Proposal p = (Proposal)oProposal.get();
            // Buscamos el archivo a descargar
            File f = null;
            for (File file : p.getAsociatedFiles()){
                if (file.getId() == file_id){
                    f = file;
                    break;
                }
            }
            if (f == null) return null;
            else {
                Path path = Paths.get(f.getFileName() + "." + f.getExtension());
                java.nio.file.Files.write(path, f.getFile().getData());
                return f.getFile().getData();
            }
        }
        return null;
    }
}
