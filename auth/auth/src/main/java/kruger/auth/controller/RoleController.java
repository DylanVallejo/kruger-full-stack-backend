package kruger.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kruger.auth.entity.Role;
import kruger.auth.service.RoleService;

@RestController
/*@RequestMapping("/app")*/
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/")
	public Iterable<Role> getAll() {
		return roleService.getAll();
	}
	
	@PostMapping("/createNewRole")
	public ResponseEntity<?> createNewRole(@RequestBody Role role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.createNewRole(role));
    }
	/*
	public Role createNewRole(@RequestBody Role role) {
		System.out.print(role.toString());
		return roleService.createNewRole(role);
	}*/	
	
}
