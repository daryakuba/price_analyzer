package analyzer.controllers;

import java.util.List;
import java.util.Optional;

import analyzer.models.Base;
import analyzer.services.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class BaseController {
    private final BaseService baseService;

    @Autowired
    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    @PostMapping("/add")
    public void post(@RequestBody Base base) {
        baseService.addBase(base);
    }

    @GetMapping("/getAll")
    public @ResponseBody
    List<Base> getAll() {
        return baseService.findAll();
    }

    @GetMapping("/getByProduct/{id}")
    public @ResponseBody
    List<Base> getByProduct(@PathVariable long id) {
        return baseService.findByProductIdOrderByTime(id);
    }
}
