package com.bezkoder.spring.files.upload.db.repository;

import com.bezkoder.spring.files.upload.db.model.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends CrudRepository<Cat, Integer> {
    Cat findByMicrochipNumber(String microchipNumber);
}
