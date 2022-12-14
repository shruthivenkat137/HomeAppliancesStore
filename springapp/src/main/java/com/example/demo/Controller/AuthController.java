
package com.example.demo.Controller;

import com.example.demo.Model.ERole;
import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Payload.request.LoginRequest;
import com.example.demo.Payload.request.SignupRequest;
import com.example.demo.Payload.response.JwtResponse;
import com.example.demo.Payload.response.MessageResponse;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Security.jwt.JwtUtils;
import com.example.demo.Services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")

@RestController

@RequestMapping("/")
public class AuthController {

        @Autowired
        AuthenticationManager authenticationManager;

        @Autowired
        UserRepository userRepository;

        @Autowired
        RoleRepository roleRepository;

        @Autowired
        PasswordEncoder encoder;

        @Autowired
        JwtUtils jwtUtils;

        @PostMapping("/login")
        public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

                Authentication authentication = authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
                                                loginRequest.getPassword()));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtUtils.generateJwtToken(authentication);

                UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
                List<String> roles = userDetails.getAuthorities().stream()
                                .map(item -> item.getAuthority())
                                .collect(Collectors.toList());

                return ResponseEntity.ok(new JwtResponse(jwt,
                                userDetails.getUserId(),
                                userDetails.getUsername(),
                                userDetails.getEmail(),
                                roles,
                                true));
        }
        //// sign up

        @PostMapping("/signup")
        public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
                if (userRepository.existsByUserName(signUpRequest.getUsername())) {
                        return ResponseEntity
                                        .badRequest()
                                        .body(new MessageResponse("Error: Username is already taken!"));
                }

                if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                        return ResponseEntity
                                        .badRequest()
                                        .body(new MessageResponse("Error: Email is already in use!"));
                }

                // Create new user's account
                User user = new User(signUpRequest.getFullName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
                                encoder.encode(signUpRequest.getPassword()), signUpRequest.getPhoneno());

                // Set<String> strRoles = signUpRequest.getRole();
                String strRoles = signUpRequest.getRole();
                Set<Role> roles = new HashSet<>();

                if (strRoles == null) {
                        Role userRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
                                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                        user.setRoles(roles);
                } else {
                        // strRoles.forEach(role -> {
                        switch (strRoles) {
                                case "admin":
                                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                                        .orElseThrow(() -> new RuntimeException(
                                                                        "Error: Role is not found."));
                                        roles.add(adminRole);
                                        user.setRoles(roles);
                                        break;

                                default:
                                        Role userRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
                                                        .orElseThrow(() -> new RuntimeException(
                                                                        "Error: Role is not found."));
                                        roles.add(userRole);
                                        user.setRoles(roles);
                        }
                        // });
                }

                userRepository.save(user);

                return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }
}
