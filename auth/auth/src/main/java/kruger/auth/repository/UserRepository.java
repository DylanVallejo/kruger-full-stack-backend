package kruger.auth.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kruger.auth.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
	
}
