package kruger.products.model;

import kruger.products.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommetRepository extends JpaRepository<Comment, Long> {

}