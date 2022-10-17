package com.bamboo.example.domain.user.controller;

import com.bamboo.example.domain.user.dto.UserRequestDto;
import com.bamboo.example.domain.user.dto.UserResponseDto;
import com.bamboo.example.domain.user.service.UserService;
import com.bamboo.example.global.config.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto.SignUp> signup(@RequestBody UserRequestDto.SignUp request) {
        UserResponseDto.SignUp response = userService.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequestDto.Login request,
                                         HttpSession httpSession) {
        String sessionId = userService.login(request, httpSession);

        return ResponseEntity.status(HttpStatus.CREATED).body(sessionId);
    }

    @GetMapping("/whoami")
    public String whoami() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        System.out.println("username = " + userDetails.getUsername());

        return userDetails.getUsername();
    }
}
