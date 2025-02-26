package br.com.organization.organize.domain.services;

import br.com.organization.organize.application.dto.user.UserRequest;
import br.com.organization.organize.application.gateways.user.UserManager;
import br.com.organization.organize.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserManager userManager;

    public UserService(UserManager userManager) {
        this.userManager = userManager;
    }

    public User createUser(UserRequest userRequest) throws Exception {
        User user = new User(
                userRequest.name(),
                userRequest.email(),
                userRequest.password()
        );

        userManager.create(user);

        return user;
    }

    public Page<User> getUserList(Pageable pageable) throws Exception {
        return userManager.gerUserList(pageable);
    }
}
