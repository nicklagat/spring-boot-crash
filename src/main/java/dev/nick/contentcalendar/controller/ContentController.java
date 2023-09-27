package dev.nick.contentcalendar.controller;

import dev.nick.contentcalendar.model.Content;
import dev.nick.contentcalendar.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/content")
@CrossOrigin()
public class ContentController {

    private final ContentCollectionRepository contentCollectionRepository;


    @Autowired
    public ContentController(ContentCollectionRepository contentCollectionRepository) {
        this.contentCollectionRepository = contentCollectionRepository;
    }



    // make a request and get all pieces of content in our repository

    @GetMapping("")
    public List<Content> getAllContent(){

        return contentCollectionRepository.findAll();

    }


    @GetMapping("/{uuid}")
    public Content getContentById(@PathVariable UUID uuid){

        return contentCollectionRepository.findById(uuid).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found"));
    }

    // create, delete, update

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){

        contentCollectionRepository.save(content);
    }
}
