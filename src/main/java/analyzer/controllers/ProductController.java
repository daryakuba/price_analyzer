package analyzer.controllers;

import java.util.List;

import analyzer.models.Product;
import analyzer.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public void post(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping("/getAll")
    public @ResponseBody
    List<Product> getAll() {
        return productService.findAll();
    }
}