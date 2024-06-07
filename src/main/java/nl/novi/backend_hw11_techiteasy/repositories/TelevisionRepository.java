package nl.novi.backend_hw11_techiteasy.repositories;
import nl.novi.backend_hw11_techiteasy.models.Television;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    List<Television> findAllTelevisionsByBrandEqualsIgnoreCase(String brand);
}
