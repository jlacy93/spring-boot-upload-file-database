package com.bezkoder.spring.files.upload.db.model;

import org.springframework.data.annotation.Id;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Cat extends AbstractEntity{
    @Id
    private String microchipNumber;

    private String name;

    private String color;

    private String image;

    private String fileName;

    private String type;

    @Lob
    private byte[] data;

    public Cat(){

    }

    public Cat(String microchipNumber, String name, String color, String image, String fileName, String type, byte[] data) {
        this.microchipNumber = microchipNumber;
        this.name = name;
        this.color = color;
        this.image = image;
        this.fileName = fileName;
        this.type = type;
        this.data = data;
//        String fileDownloadUri = getFileDownloadUri();
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFileDownloadUri() {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("cat/")
                .path(this.stringId())
                .toUriString();
    }

}
