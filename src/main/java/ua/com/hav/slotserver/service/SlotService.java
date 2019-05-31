package ua.com.hav.slotserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.slotserver.exception.SlotNotFoundException;
import ua.com.hav.slotserver.model.Slot;
import ua.com.hav.slotserver.repository.SlotRepository;

import java.util.List;

@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    public Slot findById(Long id) {
        return slotRepository.findById(id)
                .orElseThrow(() -> new SlotNotFoundException(id));
    }

    @Transactional
    public void save(Slot slot) {
        slotRepository.save(slot);
    }

    public List<Slot> findAll() {
        return slotRepository.findAll();
    }
}
