package com.is2.api.project.Auth;

import com.is2.api.project.Models.Users;
import com.is2.api.project.Jwt.JwtService;
import com.is2.api.project.Models.Role;
import com.is2.api.project.Services.EmailService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.is2.api.project.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    public AuthResponse register(RegisterRequest request) {
        Users users = Users.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .firstname(request.getFirstname())
            .lastname(request.lastname)
            .country(request.getCountry())
            .role(Role.USER)
            .mail(request.getMail())
            .build();

        userRepository.save(users);
        EmailService.sendEmail(users.getMail(),"REGISTRO", "REGISTRO EXITOSO");
        return AuthResponse.builder()
            .token(jwtService.getToken(users))
            .build();
        
    }

}
