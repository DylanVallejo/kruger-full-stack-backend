package kruger.products.service;

import kruger.products.entity.Product;
import kruger.products.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceimpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findProductoByid(Long id) {
        return  productRepository.findById(id);
    }

    @Override
    public void UpdateStock(Long stock, Long id) {
        Product productStock = productRepository.findById(id).get();
        productStock.setStock(stock);
        productRepository.save(productStock);
    }

}
