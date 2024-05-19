package analyzer.services;

import java.util.List;

import analyzer.models.Shop;
import analyzer.repos.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public boolean addShop(Shop shop) {
        Shop shopFromDb = shopRepository.findByName(shop.getName());

        if (shopFromDb != null) {
            return false;
        }
        shopRepository.save(shop);
        return true;
    }

    @Override
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    @Override
    public Shop save(Shop shop) {
        return null;
    }
}
