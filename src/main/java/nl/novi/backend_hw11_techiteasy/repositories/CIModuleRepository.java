package nl.novi.backend_hw11_techiteasy.repositories;

import nl.novi.backend_hw11_techiteasy.models.CIModule;
import nl.novi.backend_hw11_techiteasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CIModuleRepository  extends JpaRepository<CIModule, Long> {
}
