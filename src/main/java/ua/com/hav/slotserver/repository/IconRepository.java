package ua.com.hav.slotserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.slotserver.model.Icon;

import java.util.Optional;

public interface IconRepository extends JpaRepository<Icon, Long> {
    Optional<Icon> findByValue(char value);
}
