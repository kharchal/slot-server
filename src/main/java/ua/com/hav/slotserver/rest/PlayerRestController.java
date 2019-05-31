package ua.com.hav.slotserver.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.hav.slotserver.model.History;
import ua.com.hav.slotserver.model.Player;
import ua.com.hav.slotserver.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/slotAPI")
public class PlayerRestController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/players/{id}", method = RequestMethod.GET)
    public Player findById(@PathVariable Long id) {
        return playerService.findById(id);
    }

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public List<Player> findAll() {
        return playerService.findAll();
    }

    @RequestMapping(value = "/players/{id}/histories", method = RequestMethod.GET)
    public List<History> findHistories(@PathVariable Long id) {
        return playerService.findById(id).getHistory();
    }
}
