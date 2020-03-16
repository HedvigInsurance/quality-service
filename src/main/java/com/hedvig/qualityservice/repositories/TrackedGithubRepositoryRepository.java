package com.hedvig.qualityservice.repositories;

import com.hedvig.qualityservice.entities.TrackedGithubRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TrackedGithubRepositoryRepository extends CrudRepository<TrackedGithubRepository, UUID> {
}
