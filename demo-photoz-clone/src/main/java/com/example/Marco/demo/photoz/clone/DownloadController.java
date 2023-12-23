package com.example.Marco.demo.photoz.clone;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DownloadController {
    @GetMapping("/download/{id}")
    //public byte[] // we can do that but ResponseEntity
    public ResponseEntity<byte[]> download(@PathVariable String id) {
        byte[] date;
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(date, httpHeaders, HttpStatus.OK);
    }


}
