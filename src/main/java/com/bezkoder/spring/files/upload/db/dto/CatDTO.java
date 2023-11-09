package com.bezkoder.spring.files.upload.db.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.Lob;
@NoArgsConstructor
public class CatDTO {
    public String microchipNumber;

    public String name;

    public String color;

    public String image;

    public String fileName;

    public String type;

    public byte[] data;


//CatDTO(String microchipNumber, String name, String color, String image) {
//        this.microchipNumber = microchipNumber;
//        this.name = name;
//        this.color = color;
//        this.image = image;
//    }
CatDTO(String microchipNumber, String name, String color, String image, String fileName, String type, byte[] data) {
        this.microchipNumber = microchipNumber;
        this.name = name;
        this.color = color;
        this.image = image;
        this.fileName = fileName;
        this.type = type;
        this.data = data;
    }

    public String getMicrochipNumber() {
        return microchipNumber;
    }

    public void setMicrochipNumber(String microchipNumber) {
        this.microchipNumber = microchipNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public byte[] getData() {
//        return data;
//    }
//
//    public void setData(byte[] data) {
//        this.data = data;
//    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
