package com.hedvig.qualityservice.web;

public class CreateTrackedGithubRepositoryDto {
    private String owner;
    private String name;

    public CreateTrackedGithubRepositoryDto() {
    }

    public CreateTrackedGithubRepositoryDto(final String owner, final String name) {
        this.owner = owner;
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }
}
