package dev.nick.contentcalendar.repository;

import dev.nick.contentcalendar.model.Content;
import dev.nick.contentcalendar.model.Status;
import dev.nick.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ContentCollectionRepository {
    // for now ,we are using in memory collection to act as our database that's why we have named it this way
    // later on we will be implementing the jpa to work with a database

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){};


    public List<Content> findAll(){

        return contentList;
    }

    public Optional<Content> findById(UUID uuid){
        return contentList.stream().filter(c-> c.uuid().equals(uuid)).findFirst(); // check the notes
    }

    @PostConstruct
    private void init(){
        Content content1 = new Content(
                UUID.fromString("7f9f5ead-dd48-412c-aa26-f0dc91022bee"),
                "Ev Blog",
                "This is an EV blog",
                Status.IDEA,
                Type.CONFERENCE_TALK,
                LocalDateTime.now(),
                null,
                "https://www.youtube.com/watch?v=EBlSVAnrggc"

        );

        contentList.add(content1);
    }


    public void save(Content content) {

        contentList.add(content);
    }


}
