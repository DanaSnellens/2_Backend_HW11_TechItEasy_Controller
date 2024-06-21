package nl.novi.backend_hw11_techiteasy.repositories;

import nl.novi.backend_hw11_techiteasy.models.RemoteController;
import nl.novi.backend_hw11_techiteasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemoteControllerRepository  extends JpaRepository<RemoteController, Long> {
}
