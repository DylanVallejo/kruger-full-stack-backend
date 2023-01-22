package kruger.auth.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kruger.auth.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository <Role, Long> {

}
