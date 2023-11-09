package com.bezkoder.spring.files.upload.db.controller;


import com.bezkoder.spring.files.upload.db.dto.CatDTO;
import com.bezkoder.spring.files.upload.db.message.ResponseMessage;
import com.bezkoder.spring.files.upload.db.model.Cat;
import com.bezkoder.spring.files.upload.db.model.FileDB;
import com.bezkoder.spring.files.upload.db.service.CatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@CrossOrigin("http://localhost:4200")
public class CatController {
    @Autowired
    CatService catService;


    @PostMapping(value = "/saveCat")
    public ResponseEntity<ResponseMessage> processCatDataForm(@RequestParam("cat") String cat, @RequestPart(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws IOException {
        ResponseEntity response;
        ObjectMapper mapper = new ObjectMapper();
        CatDTO catDTO = mapper.readValue(cat, CatDTO.class);

        if(catDTO.getMicrochipNumber() == null || catDTO.getMicrochipNumber().isBlank())
        {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("All cats require a Microchip number.");
            return response;
        }
        Boolean existingCat = catService.findExistingCat(catDTO);

        try{

        if(existingCat == true){
            catService.updateCat(catDTO);
            response = ResponseEntity.status(HttpStatus.OK).body("[TODO]Existing Cat has been updated.");
        } else {
            catService.saveCat(catDTO, file);
            response = ResponseEntity.status(HttpStatus.OK).body("New cat logged.");
        }

        return response;
        } catch (Exception e) {
            return response = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Unable to save the cat, please try again.");
        }
    }

    @GetMapping("/cat")
    public Iterable<Cat> getCats(){
        return catService.findAllCats();
    }

    @GetMapping("/cat/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable int id) {
        Cat cat = catService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + cat.getFileName() + "\"")
                .body(cat.getData());
    }


}
