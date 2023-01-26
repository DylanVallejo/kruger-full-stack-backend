package kruger.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kruger.auth.entity.User;
import kruger.auth.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User registerNewUser( User user) {
		return userRepository.save(user);
	}
}