package analyzer.repos;

import java.util.List;
import java.util.Optional;

import analyzer.models.Base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository<Base, Long> {
    Optional<Base> findById(Long id);

    List<Base> findByProductId(Long id);
    List<Base> findByProductIdOrderByTime(Long id);
}
