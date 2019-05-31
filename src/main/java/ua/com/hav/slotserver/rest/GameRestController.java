package ua.com.hav.slotserver.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.hav.slotserver.logic.SlotLogic;
import ua.com.hav.slotserver.model.Player;
import ua.com.hav.slotserver.model.Slot;
import ua.com.hav.slotserver.service.PlayerService;
import ua.com.hav.slotserver.service.SlotService;
import ua.com.hav.slotserver.view.BetResult;

import java.util.List;

@RestController
@RequestMapping("/slotAPI")
public class GameRestController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private SlotService slotService;

    @Autowired
    private SlotLogic slotLogic;

    @RequestMapping(value = "/bet", method = RequestMethod.POST)
    public BetResult bet(@RequestParam(name = "player_id") Long playerId,
                      @RequestParam(name = "slot_id") Long slotId,
                      @RequestParam Integer bet) {

        Player player = playerService.findById(playerId);
        Slot slot = slotService.findById(slotId);
        int result = slotLogic.bet(player, slot, bet);
        slotService.save(slot);
        playerService.save(player);
        List<String> state = slotLogic.getView(slot);
        BetResult betResult = new BetResult();
        betResult.setBalance(player.getBalance());
        betResult.setPrize(result);
        betResult.setState(state);
        return betResult;
    }
}
