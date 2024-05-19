package analyzer.services;

import java.util.List;

import analyzer.models.Product;
import analyzer.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean addProduct(Product product) {
        Product productFromDb = productRepository.findByName(product.getName());

        if (productFromDb != null) {
            return false;
        }
        productRepository.save(product);
        return true;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return null;
    }
}
