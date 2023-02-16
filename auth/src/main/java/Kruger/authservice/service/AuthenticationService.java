package Kruger.authservice.service;

import Kruger.authservice.entity.Role;
import Kruger.authservice.entity.User;
import Kruger.authservice.model.AuthenticationRequest;
import Kruger.authservice.model.AuthenticationResponse;
import Kruger.authservice.model.RegisterRequest;
import Kruger.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public User register(RegisterRequest request) {

    var user = User.builder()
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .email(request.getEmail())
            .status(true)
            .password(passwordEncoder.encode(request.getPassword()))
            .role(request.getRole() == null ? Role.USER : Role.ADMIN)
            .build();
            System.out.println(user.toString());
    repository.save(user);
    return user;

  }
  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );
    var user = repository.findByEmail(request.getEmail())
            .orElseThrow();
//    String role = user.getRole() == Role.USER ? "USER" : "ADMIN"; recuerdo del jonathan que escribe mal :v
//    String role = user.getRole().toString();
    String role = user.getRole().toString();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
            .token(jwtToken)
            .role(role)
            .build();
  }
  public AuthenticationResponse validate(String token, User user) {
    if (!jwtService.isTokenValid(token, user))
      return null;
    String username = jwtService.extractUsername(token);
    if (!repository.findByEmail(username).isPresent())
      return null;
    return new AuthenticationResponse(token);
  }
}


