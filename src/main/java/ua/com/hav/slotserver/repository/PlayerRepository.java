package ua.com.hav.slotserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.slotserver.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
