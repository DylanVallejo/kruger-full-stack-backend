package kruger.consumermicroservice.service;

import kruger.consumermicroservice.entity.User;
import kruger.consumermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();
    Optional<User> getUserById(Long id);
    User save(User user);
    public void delete(Long id);
    public Optional<User> findByEmail(String email);

}
