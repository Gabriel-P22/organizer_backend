package br.com.organization.organize.application.controllers;

import br.com.organization.organize.application.dto.user.UserRequest;
import br.com.organization.organize.application.dto.user.UserResponse;
import br.com.organization.organize.domain.entity.User;
import br.com.organization.organize.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/list")
    ResponseEntity<Page<UserResponse>> getUserList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String orderBy
            ) throws Exception {

        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));

        return ResponseEntity.ok(service.getUserList(pageable).map(user -> new UserResponse(
                user.name(),
                user.email(),
                user.password()
        )));
    }
}
