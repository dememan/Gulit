package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository <User, Long> {
    public List<User> findAll();
    public Optional<User>  findById(Long id);
    public Optional<User> findById(long id);
    public Optional<User> findByUsername(String username);
    public User save(User user);
    public  void deleteById(long id);

}
