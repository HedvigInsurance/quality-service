package com.hedvig.qualityservice.services.github.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubApiRepositoryDto {
    private Long id;
    private String name;
    private String fullName;
    private Owner owner;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Owner getOwner() {
        return owner;
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Owner {
        private Long id;
        private String login;

        public Owner() {
        }

        public Owner(final Long id, final String login) {
            this.id = id;
            this.login = login;
        }

        public Long getId() {
            return id;
        }

        public String getLogin() {
            return login;
        }
    }
}
