package br.com.organization.organize.application.gateways.user;

import br.com.organization.organize.domain.entity.User;

public interface UserManager {
    User create(User user) throws Exception;
}
