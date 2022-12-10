package com.example.Marco.demo.photoz.clone.photo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotozController {

    private Map<String, Photo> db = new HashMap<>() {
        {
            put("1", new Photo("1", "hello.jpg"));
        }
    };

    @GetMapping("/")
    public String hello() {
        return "ling is fat";
    }

    @GetMapping("/photoz")
    public Collection<Photo> get() {
        return db.values();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = db.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    /*
    * in the console browser *
    * (async function deletePhoto(id) {
        await fetch("http://localhost:8080/photoz/" + id, {
                method: "DELETE"
          })
    })("5")*/

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id) {
        Photo photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    /*
    * in the console browser *
    (async function createPhoto() {
        let photo = {"fileName": "hello.jpg"};

        await fetch("http://localhost:8080/photoz", {
                method: "POST",
                headers: {
            "Accept": "application/json",
                    "Content-Type": "application/json"
        },
        body: JSON.stringify(photo)
                    })
                    .then(result => result.text())
                    .then(text => alert(text));
    })();
    */

    /*{ we dont need it any more bcz use html and upload a file!

        @PostMapping("/photoz")
        public Photo creat (@RequestBody @Valid Photo photo){
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
        return photo;
    }
   *//* adding this dependency, for @Valid and now in Photo class we add
    <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>*//*

    }*/

    @PostMapping("/photoz")
    public Photo creat(@RequestPart("data") MultipartFile file) throws IOException { // data is the key in html http://localhost:8080/Upload.html
        Photo photo = new Photo();

        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        db.put(photo.getId(), photo);
        return photo;
    }


}
