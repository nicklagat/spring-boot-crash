package dev.nick.contentcalendar.repository;

import dev.nick.contentcalendar.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContentRepository extends JpaRepository<Content,UUID> {



}
