package kruger.products.service;

import kruger.products.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommetService {
    public List<Comment> findAll();
    Comment save(Comment comment);
    public void delete(Long id);
    public Optional<Comment> findReviewByid(Long id);

    public List<Comment> findByProductId(Integer id);

}
