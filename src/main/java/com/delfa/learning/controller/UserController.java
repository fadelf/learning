package com.delfa.learning.controller;

import com.delfa.learning.service.impl.AuthenticationService;
import com.delfa.learning.wrapper.AuthenticationRequest;
import com.delfa.learning.wrapper.AuthenticationResponse;
import com.delfa.learning.wrapper.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final AuthenticationService authenticationService;

    @RequestMapping(path = "/register",
            method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest request) {
        AuthenticationResponse response = authenticationService.register(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(path = "/authenticate",
            method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUSer(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = authenticationService.authenticate(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
