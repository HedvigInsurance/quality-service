package com.hedvig.qualityservice.services;

import com.hedvig.qualityservice.entities.TrackedGithubRepository;
import com.hedvig.qualityservice.repositories.TrackedGithubRepositoryRepository;
import com.hedvig.qualityservice.services.github.GithubClient;
import com.hedvig.qualityservice.web.CreateTrackedGithubRepositoryDto;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TrackedGithubRepositoryServiceTest {
    @Test
    public void createsTrackedGithubRepository() {
        final TrackedGithubRepositoryRepository repositoryRepository = mock(TrackedGithubRepositoryRepository.class);
        final GithubClient githubClient = mock(GithubClient.class);
        final ArgumentCaptor<TrackedGithubRepository> repositoryCaptor = ArgumentCaptor.forClass(TrackedGithubRepository.class);
        final TrackedGithubRepositoryService trackedGithubRepositoryService = new TrackedGithubRepositoryService(repositoryRepository, githubClient);

        final CreateTrackedGithubRepositoryDto createTrackedGithubRepositoryDto = new CreateTrackedGithubRepositoryDto("HedvigInsurance", "product-pricing");

        final TrackedGithubRepository result = trackedGithubRepositoryService.createTrackedGithubRepository(createTrackedGithubRepositoryDto);

        verify(repositoryRepository).save(repositoryCaptor.capture());
        assertThat(repositoryCaptor.getValue().getOwner()).isEqualTo(createTrackedGithubRepositoryDto.getOwner());
        assertThat(repositoryCaptor.getValue().getName()).isEqualTo(createTrackedGithubRepositoryDto.getName());
        assertThat(result.getOwner()).isEqualTo(createTrackedGithubRepositoryDto.getOwner());
        assertThat(result.getName()).isEqualTo(createTrackedGithubRepositoryDto.getName());
    }
}
