package com.bamboo.example.domain.user.dto;

import com.bamboo.example.domain.user.User;
import com.bamboo.example.domain.user.UserRole;
import lombok.*;

public class UserResponseDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SignUp {

        private Long id;
        private String username;
        private UserRole role;

        public static SignUp of(User user) {
            return SignUp.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .role(user.getRole())
                    .build();
        }
    }
}
