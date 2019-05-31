package ua.com.hav.slotserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.slotserver.model.History;
import ua.com.hav.slotserver.repository.HistoryRepository;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Transactional
    public void save(History history) {
        historyRepository.save(history);
    }
}
