package ua.com.hav.slotserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.slotserver.exception.PlayerNotFoundException;
import ua.com.hav.slotserver.model.Player;
import ua.com.hav.slotserver.repository.PlayerRepository;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player findById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Transactional
    public void save(Player player) {
        playerRepository.save(player);
    }
}
