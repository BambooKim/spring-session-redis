package com.bamboo.example.domain.user;

import lombok.Getter;

@Getter
public enum UserRole {

    ROLE_ADMIN("관리자"), ROLE_USER("사용자");

    private String description;

    UserRole(String description) {
        this.description = description;
    }
}
