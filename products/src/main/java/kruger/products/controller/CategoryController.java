package kruger.products.controller;

import kruger.products.entity.Category;
import kruger.products.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/category")
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

    @PostMapping()
    public ResponseEntity<Category> save(@RequestBody Category category){

        Category categoryNew = categoryService.save(category);
        return ResponseEntity.ok(categoryNew);
    }
}

