package kruger.products.controller;

import kruger.products.entity.Category;
import kruger.products.entity.Product;
import kruger.products.service.CategoryService;
import kruger.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = productService.findAll();
        if(products.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getById(@PathVariable("id") Long id){
        Optional<Product> product = productService.findProductoByid(id);
        if(product==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(product);
    }

    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product product){

        Optional<Category> category= categoryService.findCategoryByid(product.getCategory().getId());
        product.setCategory(category.get());
        Product productNew = productService.save(product);
        return ResponseEntity.ok(productNew);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product,@PathVariable("id") Long id ){
        Optional< Category> category= categoryService.findCategoryByid(product.getCategory().getId());
        Product product1= productService.findProductoByid(id).get();
        product1.setCategory(category.get());
        product1.setProductName(product.getProductName());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        product1.setStock(product.getStock());
        product1.setItsInOffers(product.getItsInOffers());
        product1.setLastModifiedDate(new Date());
        Product productNew = productService.save(product1);
        return ResponseEntity.ok(productNew);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }


}
