package kruger.products.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kruger.products.entity.Category;
import kruger.products.entity.Comment;
import kruger.products.entity.Product;
import kruger.products.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/category")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
//@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Category Controller", description = "Crud operations for Category.")
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categorys = categoryService.findAll();
        if(categorys.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(categorys);
    }

    @GetMapping("api/{id}")
    public ResponseEntity<Optional<Category>> getById(@PathVariable("id") Long id){
        Optional<Category> category = categoryService.findCategoryByid(id);
        if(category==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(category);
    }
    
    //Busqueda  por  nombre de categoria

    @GetMapping("/nombre/{name}")
    public ResponseEntity<List<Category>> getById(@PathVariable("name") String name){
        List<Category> category = categoryService.findByName(name);
        if(category==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(category);
    }
//    @CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
    @PostMapping()
    @ConfigurationProperties(prefix = "web")
    public ResponseEntity<Category> save(@RequestBody Category category){

        Category categoryNew = categoryService.save(category);
        return ResponseEntity.ok(categoryNew);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable("id") Long id ){

        Category category1 = categoryService.findCategoryByid(id).get();

        category1.setName(category.getName());
        category1.setDescription(category.getDescription());
        category1.setLastModifiedDate(new Date());
        Category categoryNew = categoryService.save(category1);
        return ResponseEntity.ok(categoryNew);
    }

}

