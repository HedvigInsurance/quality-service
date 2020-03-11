package com.hedvig.qualityservice.services;

import com.hedvig.qualityservice.entities.TrackedGithubRepository;
import com.hedvig.qualityservice.repositories.TrackedGithubRepositoryRepository;
import com.hedvig.qualityservice.services.github.GithubClient;
import com.hedvig.qualityservice.services.github.dtos.GithubApiRepositoryDto;
import com.hedvig.qualityservice.web.CreateTrackedGithubRepositoryDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Service
public class TrackedGithubRepositoryService {
    private final TrackedGithubRepositoryRepository trackedGithubRepositoryRepository;
    private final GithubClient githubClient;

    public TrackedGithubRepositoryService(
        final TrackedGithubRepositoryRepository trackedGithubRepositoryRepository,
        final GithubClient githubClient
    ) {
        this.trackedGithubRepositoryRepository = requireNonNull(trackedGithubRepositoryRepository);
        this.githubClient = requireNonNull(githubClient);
    }

    public TrackedGithubRepository createTrackedGithubRepository(final CreateTrackedGithubRepositoryDto dto) {
        final GithubApiRepositoryDto githubApiRepositoryDto =
            githubClient.getRepository(dto.getOwner(), dto.getName()); // Use the "real" repo to a) verify it exists and b) get the correct name casing

        final TrackedGithubRepository repository = new TrackedGithubRepository();
        repository.setId(UUID.randomUUID());
        repository.setOwner(githubApiRepositoryDto.getOwner().getLogin());
        repository.setName(githubApiRepositoryDto.getName());
        trackedGithubRepositoryRepository.save(repository);

        return repository;
    }

    public void trackProgrammingLanguageDistribution(final UUID repositoryId) {
        // TODO hm, how can we do this in a good way?
    }

    public Optional<TrackedGithubRepository> findOne(final UUID repositoryId) {
        return trackedGithubRepositoryRepository.findById(repositoryId);
    }
}
