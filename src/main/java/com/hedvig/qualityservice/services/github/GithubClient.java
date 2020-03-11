package com.hedvig.qualityservice.services.github;

import com.hedvig.qualityservice.services.github.dtos.GithubApiRepositoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "GithubClient", url = "https://api.github.com")
public interface GithubClient {
    @GetMapping("repos/{owner}/{name}")
    GithubApiRepositoryDto getRepository(
        final @PathVariable("owner") String owner,
        final @PathVariable("name") String name
    );
}
