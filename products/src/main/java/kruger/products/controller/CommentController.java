package kruger.products.controller;


import kruger.products.entity.Comment;
import kruger.products.entity.Product;
import kruger.products.service.CommetService;
import kruger.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Comment>> getById(@PathVariable("id") Long id){
        Optional<Comment> review = commetService.findReviewByid(id);
        if(review==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(review);
    }

    @PostMapping()
    public ResponseEntity<Comment> save(@RequestBody Comment comment){
        Optional<Product> product= productService.findProductoByid(comment.getProduct().getId());
        comment.setProduct(product.get());
        Comment reviewNew = commetService.save(comment);
        return ResponseEntity.ok(reviewNew);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Comment> update(@RequestBody Comment comment,@PathVariable("id") Long id ){

        Optional<Product> product = productService.findProductoByid(comment.getProduct().getId());
        Comment comment1 = commetService.findReviewByid(id).get();
        comment1.setText(comment1.getText());
        comment1.setProduct(product.get());
        comment1.setLastModifiedDate(new Date());
        Comment reviewNew = commetService.save(comment1);
        return ResponseEntity.ok(reviewNew);
    }


}
