package th.mfu;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    // create hashmap for product
    private HashMap<Long, Product> productsDB = new HashMap<Long, Product>();

    // select all product
    @GetMapping("/product")
    public Collection<Product> getAllProduct() {
        return productsDB.values();
    }

    // select product by id
    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable long id) {
        // check if id exists in db
        if (!productsDB.containsKey(id)) {
            // return error message 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found");
        }
        return ResponseEntity.ok(productsDB.get(id));
    }

    // create new products
    /**
     * @param product
     * @return
     */
    @PostMapping("/product")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        // check if id exists
        if (productsDB.containsKey(product.getId())) {
            // return error message
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product id already exists");
        }

        // add employee to hashmap
        productsDB.put(product.getId(), product);

        // return created success message
        return ResponseEntity.ok("Product created");
    }
}
