package com.daneshvar.url_shorter.controller;

import com.daneshvar.url_shorter.model.UrlRecord;
import com.daneshvar.url_shorter.model.UrlRecordRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlRecordController {

    private final UrlRecordRepository urlRecordRepository;
    public UrlRecordController(UrlRecordRepository urlRecordRepository) {
        this.urlRecordRepository = urlRecordRepository;
    }

    @PostMapping("/set")
    public String createUrlRecord(@RequestBody String url) {
        UrlRecord urlRecord = new UrlRecord(url);
        urlRecordRepository.save(urlRecord);
        return urlRecord.getKey();
    }

    @GetMapping("/get/{key}")
    public  @ResponseBody  String getUrlRecord(@PathVariable String key) {
        UrlRecord url = urlRecordRepository.findByKey(key);
        return url.getUrlByKey();
    }

    @GetMapping("/goto/{key}")
    public ResponseEntity<Void> redirectToURL(@PathVariable String key) {
        UrlRecord url = urlRecordRepository.findByKey(key);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url.getUrlByKey())).build();
    }

}
