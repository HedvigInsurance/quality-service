package com.hedvig.qualityservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
public class TrackedGithubRepository {
    @Id
    private UUID id;

    @Column
    private String owner;

    @Column
    private String name;

    @Column
    private Instant createdAt = Instant.now();

    public UUID getId() {
        return id;
    }

    public void setId(final UUID uuid) {
        this.id = uuid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Instant createdAt) {
        this.createdAt = createdAt;
    }
}
