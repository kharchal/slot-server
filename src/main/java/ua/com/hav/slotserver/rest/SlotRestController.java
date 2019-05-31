package ua.com.hav.slotserver.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.hav.slotserver.logic.SlotLogic;
import ua.com.hav.slotserver.model.Slot;
import ua.com.hav.slotserver.service.SlotService;
import ua.com.hav.slotserver.view.SlotInfo;

import java.util.List;

@RestController
@RequestMapping("/slotAPI")
public class SlotRestController {

    @Autowired
    private SlotService slotService;

    @Autowired
    private SlotLogic slotLogic;

    @RequestMapping(value = "/slots", method = RequestMethod.GET)
    public List<Slot> list() {
        return slotService.findAll();
    }

    @RequestMapping(value = "/slots/{id}", method = RequestMethod.GET)
    public SlotInfo show(@PathVariable Long id) {
        Slot slot = slotService.findById(id);
        SlotInfo slotInfo = new SlotInfo();
        slotInfo.setId(slot.getId());
        slotInfo.setName(slot.getName());
        slotInfo.setPatterns(slot.getPatterns());
        slotInfo.setRails(slot.getRails());
        slotInfo.setState(slotLogic.getView(slot));
        return slotInfo;
    }
}
