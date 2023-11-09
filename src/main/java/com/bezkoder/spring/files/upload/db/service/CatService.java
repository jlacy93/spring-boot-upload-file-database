package com.bezkoder.spring.files.upload.db.service;

import com.bezkoder.spring.files.upload.db.dto.CatDTO;
import com.bezkoder.spring.files.upload.db.model.Cat;
import com.bezkoder.spring.files.upload.db.model.FileDB;
import com.bezkoder.spring.files.upload.db.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class CatService {

    @Autowired
    CatRepository catRepository;


    public void saveCat(CatDTO catDTO, MultipartFile file) throws IOException{
        Cat cat = new Cat();
        cat.setMicrochipNumber(catDTO.getMicrochipNumber());
        cat.setName(catDTO.getName());
        cat.setColor(catDTO.getColor());
        cat.setImage(catDTO.getImage());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        cat.setFileName(fileName);
        cat.setType(file.getContentType());
        cat.setData(file.getBytes());
        catRepository.save(cat);
    }

    public void updateCat(CatDTO catDTO){
        Cat updateCat = catRepository.findByMicrochipNumber(catDTO.getMicrochipNumber());
        catRepository.save(updateCat);
        //TODO: Fix this class to update changed fields, ignore nulls. Right now it does not accept new field changes, just updates last modified date.

    }

    public Iterable<Cat> findAllCats(){
        return catRepository.findAll();
    }

    public Boolean findExistingCat(CatDTO catDTO){
        Optional<Cat> cat = Optional.ofNullable(catRepository.findByMicrochipNumber(catDTO.getMicrochipNumber()));
        if(cat.isPresent()){
            return true;
        } else {
            return false;
        }
    }

    public Cat getFile(int id) {
        return catRepository.findById(id).get();
    }


}
