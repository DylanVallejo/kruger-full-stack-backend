package kruger.auth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import kruger.auth.entity.Role;
import kruger.auth.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	
	public Iterable<Role> getAll() {
		return roleRepository.findAll();
	}
	
	public Role createNewRole( Role role) {
		return roleRepository.save(role);
	}
}
