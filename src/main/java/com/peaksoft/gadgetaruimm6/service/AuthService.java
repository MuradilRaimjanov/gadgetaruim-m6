package com.peaksoft.gadgetaruimm6.service;

import com.peaksoft.gadgetaruimm6.config.jwt.JwtUtil;
import com.peaksoft.gadgetaruimm6.model.dto.LoginRequest;
import com.peaksoft.gadgetaruimm6.model.dto.LoginResponse;
import com.peaksoft.gadgetaruimm6.model.dto.RegisterRequest;
import com.peaksoft.gadgetaruimm6.model.dto.RegisterResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.LoginMapper;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.UserMapper;
import com.peaksoft.gadgetaruimm6.model.entity.User;
import com.peaksoft.gadgetaruimm6.model.enums.Role;
import com.peaksoft.gadgetaruimm6.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    AuthenticationManager authenticationManager;
    JwtUtil jwtUtil;

    public RegisterResponse register(RegisterRequest registerRequest) {
        User user = userMapper.mapToEntity(registerRequest);
        user.setPassword(user.getPassword());
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
        return userMapper.mapToResponse(user);
    }

    public LoginResponse authentication(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail());
        var jwt = jwtUtil.generateToken(user);
        return LoginMapper.mapToResponse(jwt, user);
    }

    public void forgotPassword(String email) {
        User user = userRepository.findByEmail(email);
        UUID token = UUID.randomUUID();
        user.setToken(token.toString());
        user.setTokenCreated(LocalDateTime.now());
        userRepository.save(user);
        String subject = "reset password";
        String body = "Your password change code: http://localhost:8080/api/auth/reset-password?password=&token=" + token;
        senderMail(email, subject, body);

    }

    public void resetPassword(String password, String token) throws Exception {
        User user = userRepository.findByToken(token);
        if (!checkTimeToken(user.getTokenCreated())) {
            throw new Exception("Token invalid");
        }
        user.setPassword(passwordEncoder.encode(password));
        user.setToken("");
        userRepository.save(user);
    }

    public Boolean checkTimeToken(LocalDateTime tokenCreated) {
        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(tokenCreated, now);
        return diff.toMinutes() <= 3;
    }

    public void senderMail(String toEmail, String subject, String body) throws NullPointerException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("temuchi500@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
    }

}