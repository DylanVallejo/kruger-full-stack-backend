package Kruger.authservice.controller;

import Kruger.authservice.entity.User;
import Kruger.authservice.model.AuthenticationRequest;
import Kruger.authservice.model.AuthenticationResponse;
import Kruger.authservice.model.RegisterRequest;
import Kruger.authservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<User> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  //login
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/validate")
  public ResponseEntity<AuthenticationResponse> validate(@RequestParam String token, @RequestBody User user){
    AuthenticationResponse tokenDto = service.validate(token, user);
    if(tokenDto == null)
      return ResponseEntity.badRequest().build();
    return ResponseEntity.ok(tokenDto);
  }



}
