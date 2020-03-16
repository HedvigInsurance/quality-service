package com.hedvig.qualityservice.web.dtos;

import com.hedvig.qualityservice.entities.TrackedGithubRepository;

import java.util.UUID;

public class TrackedGithubRepositoryDto {
    private final UUID id;
    private final String owner;
    private final String name;

    public TrackedGithubRepositoryDto(final UUID id, final String owner, final String name) {
        this.id = id;
        this.owner = owner;
        this.name = name;
    }

    public static TrackedGithubRepositoryDto from(final TrackedGithubRepository entity) {
        return new TrackedGithubRepositoryDto(entity.getId(), entity.getOwner(), entity.getName());
    }

    public UUID getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }
}
