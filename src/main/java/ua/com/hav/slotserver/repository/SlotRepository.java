package ua.com.hav.slotserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.slotserver.model.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long> {
}
