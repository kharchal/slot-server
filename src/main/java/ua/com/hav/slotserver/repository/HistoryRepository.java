package ua.com.hav.slotserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.slotserver.model.History;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
