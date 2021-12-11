package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository <User, Long> {

    public List<User> findAll();

    public Optional<User> findById(long id);

    public User findByName(String name);

    public Optional<User> findByUsername(String username);

}
