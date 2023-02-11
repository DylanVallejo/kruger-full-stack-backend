package kruger.products.service;

import kruger.products.entity.Comment;
import kruger.products.model.CommetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CommetServiceImpl implements CommetService{

    @Autowired
    private CommetRepository commetRepository;

    @Override
    public List<Comment> findAll() {

        return commetRepository.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return commetRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commetRepository.deleteById(id);
    }

    @Override
    public Optional<Comment> findReviewByid(Long id) {
        return commetRepository.findById(id);
    }

    @Override
    public List<Comment> findByProductId(Integer id) {
        return commetRepository.findByProductId(id);
    }

}
