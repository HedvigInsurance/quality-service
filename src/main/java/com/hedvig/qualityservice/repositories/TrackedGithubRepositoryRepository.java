package com.hedvig.qualityservice.repositories;

import com.hedvig.qualityservice.entities.TrackedGithubRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TrackedGithubRepositoryRepository extends CrudRepository<TrackedGithubRepository, UUID> {
}
