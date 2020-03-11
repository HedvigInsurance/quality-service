package com.hedvig.qualityservice.web;

import com.hedvig.qualityservice.entities.TrackedGithubRepository;
import com.hedvig.qualityservice.services.TrackedGithubRepositoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/repositories")
public class RepositoryController {
    private final TrackedGithubRepositoryService trackedGithubRepositoryService;

    public RepositoryController(final TrackedGithubRepositoryService trackedGithubRepositoryService) {
        this.trackedGithubRepositoryService = requireNonNull(trackedGithubRepositoryService);
    }

    @PostMapping("/track")
    public TrackedGithubRepositoryDto trackRepository(final @RequestBody CreateTrackedGithubRepositoryDto body) {
        final TrackedGithubRepository trackedGithubRepository = trackedGithubRepositoryService.createTrackedGithubRepository(body);
        return TrackedGithubRepositoryDto.from(trackedGithubRepository);
    }

    @GetMapping("/{repositoryId}")
    public final ResponseEntity<TrackedGithubRepositoryDto> getOne(final @PathVariable("repositoryId") UUID repositoryId) {
        return trackedGithubRepositoryService.findOne(repositoryId)
                .map(TrackedGithubRepositoryDto::from)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
