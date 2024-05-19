package analyzer.controllers;

import java.util.List;

import analyzer.models.Shop;
import analyzer.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/add")
    public void post(@RequestBody Shop shop) {
        shopService.addShop(shop);
    }

    @GetMapping("/getAll")
    public @ResponseBody List<Shop> getAll() {
        return shopService.findAll();
    }
}
