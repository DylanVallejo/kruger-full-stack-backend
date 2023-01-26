package kruger.products.service;

import kruger.products.entity.Category;
import kruger.products.model.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return  categoryRepository.findAll();    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findByNombre(String term) {
        return categoryRepository.findByName(term);
    }
    
    @Override
    public List<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Optional<Category> findCategoryByid(Long id) {
        return categoryRepository.findById(id);
    }
}
