package com.bamboo.example.domain.user.dto;

import lombok.*;

public class UserRequestDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignUp {

        private String username;
        private String password;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Login {

        private String username;
        private String password;
    }

}
