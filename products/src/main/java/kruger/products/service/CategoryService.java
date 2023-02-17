package kruger.products.service;

import kruger.products.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public List<Category> findAll();
    Category save(Category category);
    public void delete(Long id);
    public List<Category> findByNombre(String term);
    public Optional<Category> findCategoryByid(Long id);
    public List<Category> findByName(String name);
}
