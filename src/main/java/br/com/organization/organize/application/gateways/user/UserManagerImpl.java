package br.com.organization.organize.application.gateways.user;

import br.com.organization.organize.domain.entity.User;
import br.com.organization.organize.infra.persistence.user.UserEntity;
import br.com.organization.organize.infra.persistence.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private final UserRepository repository;

    public UserManagerImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) throws Exception {
        try {
            UserEntity entity = new UserEntity(
                    user.name(),
                    user.email(),
                    user.password()
            );

            repository.save(entity);

            return user;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public Page<User> gerUserList(Pageable pageable) throws Exception {
        try {
            Page<UserEntity> entityPage = repository.findAll(pageable);
            return entityPage.map(user -> new User(user.getName(), user.getEmail(), user.getPassword()));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
