package dev.nick.contentcalendar.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.UUID;

public record Content(
        @Id
        @GeneratedValue
        UUID uuid,

        @NotBlank
        String title,
        @NotBlank
        String description,
        Status status,  // this will be an enum
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
