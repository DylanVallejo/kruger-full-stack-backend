package kruger.products.service;

import kruger.products.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> findAll();
    Product save(Product product);
    public void delete(Long id);

    public Optional<Product> findProductoByid(Long id);

    void UpdateStock(Long stock,Long id);
}
