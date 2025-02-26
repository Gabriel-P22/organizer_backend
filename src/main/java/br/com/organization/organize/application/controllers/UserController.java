package br.com.organization.organize.application.controllers;

import br.com.organization.organize.application.dto.user.UserRequest;
import br.com.organization.organize.application.dto.user.UserResponse;
import br.com.organization.organize.domain.entity.User;
import br.com.organization.organize.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    ResponseEntity<UserResponse> createUser(@RequestBody UserRequest body) throws Exception {
        User domainUser = service.createUser(body);
        return ResponseEntity.ok(new UserResponse(
                domainUser.name(),
                domainUser.email(),
                domainUser.password()
        ));
    }
}
