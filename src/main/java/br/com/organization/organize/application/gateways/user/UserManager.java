package br.com.organization.organize.application.gateways.user;

import br.com.organization.organize.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserManager {
    User create(User user) throws Exception;
    Page<User> gerUserList(Pageable pageable) throws Exception;
}
