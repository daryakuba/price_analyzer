package analyzer.services;

import java.util.List;
import java.util.Optional;

import analyzer.models.Base;

public interface BaseService {
    void addBase(Base base);

    List<Base> findAll();

    Base save(Base base);

    List<Base> findByProductId(Long id);
    List<Base> findByProductIdOrderByTime(Long id);
}
