package nl.novi.backend_hw11_techiteasy.repositories;

import nl.novi.backend_hw11_techiteasy.models.Television;
import nl.novi.backend_hw11_techiteasy.models.WallBracket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WallBracketRepository  extends JpaRepository<WallBracket, Long> {
}
