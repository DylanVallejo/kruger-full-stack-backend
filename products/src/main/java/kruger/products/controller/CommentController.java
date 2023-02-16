package kruger.products.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import kruger.products.entity.Comment;
import kruger.products.entity.Product;
import kruger.products.service.CommetService;
import kruger.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("api/comment")
@Tag(name = "Comment Controller", description = "Crud operations for Comment.")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class CommentController {

    @Autowired
    private CommetService commetService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Comment>> findAll(){
        List<Comment> reviews = commetService.findAll();
        if(reviews.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping( "/product/{id}" )
    public ResponseEntity<?> findByProductId(@PathVariable("id") Integer id){
        List<Comment> reviews = commetService.findByProductId(id);
//        Map<String, String> mensaje = new HashMap<>();
        if(reviews.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aun no exsiten comentarios");
        return ResponseEntity.ok(reviews);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Optional<Comment>> getById(@PathVariable("id") Long id){
        Optional<Comment> review = commetService.findReviewByid(id);
        if(review==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(review);
    }

//    @PostMapping()
//    public ResponseEntity<Comment> save(@RequestBody Comment comment){
//        Optional<Product> product= productService.findProductoByid(comment.getProduct().getId());
//        comment.setProduct(product.get());
//        Comment reviewNew = commetService.save(comment);
//        return ResponseEntity.ok(reviewNew);
//    }

        @PostMapping("/product/{id}")
        public ResponseEntity<?> save(@RequestBody Comment comment , @PathVariable("id") Long id ){
            Optional<Product> product= productService.findProductoByid(id);

            comment.setProduct(product.get());
            Comment reviewNew = commetService.save(comment);

            return ResponseEntity.ok(reviewNew);
        }




    @PutMapping("/update/{id}")
    public ResponseEntity<Comment> update(@RequestBody Comment comment,@PathVariable("id") Long id ){

        Optional<Product> product = productService.findProductoByid(comment.getProduct().getId());
        Comment comment1 = commetService.findReviewByid(id).get();
        comment1.setText(comment.getText());
        comment1.setProduct(product.get());
        comment1.setLastModifiedDate(new Date());
        Comment reviewNew = commetService.save(comment1);
        return ResponseEntity.ok(reviewNew);
    }


}
