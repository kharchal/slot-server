package ua.com.hav.slotserver.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.hav.slotserver.exception.NotEnoughMoneyException;
import ua.com.hav.slotserver.exception.WrongBetException;
import ua.com.hav.slotserver.model.History;
import ua.com.hav.slotserver.model.Icon;
import ua.com.hav.slotserver.model.Player;
import ua.com.hav.slotserver.model.Slot;
import ua.com.hav.slotserver.service.HistoryService;
import ua.com.hav.slotserver.service.IconService;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class SlotLogic {

    @Autowired
    private IconService iconService;

    @Autowired
    private HistoryService historyService;

    public static final Integer ROWS_TO_SHOW = 3;
    private Random random = new Random();
    private Map<Character, Pair<Integer, Integer>> coordinates =
            new HashMap<Character, Pair<Integer, Integer>>(){{

                put('A', new Pair<>(0, 0));
                put('B', new Pair<>(0, 1));
                put('C', new Pair<>(0, 2));
                put('D', new Pair<>(1, 0));
                put('E', new Pair<>(1, 1));
                put('F', new Pair<>(1, 2));
                put('G', new Pair<>(2, 0));
                put('H', new Pair<>(2, 1));
                put('I', new Pair<>(2, 2));
    }};

    public int bet(Player player, Slot slot, Integer bet) {
        List<Integer> allowedBets = slot.getAllowedBets();
        if (!allowedBets.contains(bet)) {
            throw new WrongBetException(bet);
        }
        if (player.getBalance() < bet) {
            throw new NotEnoughMoneyException(bet);
        }
        int[] state = slot.getState();
        List<String> rails = slot.getRails();
        for (int i = 0; i < state.length; i++) {
            int length = rails.get(i).length();
            state[i] = random.nextInt(100) % length;
        }
        List<String> view = getView(slot);
        List<String> patterns = slot.getPatterns();
        List<List<Character>> results = new ArrayList<>();
        for (String pattern : patterns) {
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < pattern.length(); i++) {
                char ch = pattern.charAt(i);
                Pair<Integer, Integer> pair = coordinates.get(ch);
                int x = pair.getX();
                int y = pair.getY();
                char c = view.get(x).charAt(y);
                list.add(c);
            }
            results.add(list);
        }
        int bonus = 0;
        for (List<Character> list : results) {
            int matchesCount = 0;
            char ch = ' ';
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) == list.get(i + 1)) {
                    matchesCount++;
                    ch = list.get(i);
                }
            }
            System.out.println("list = " + list);
            if (matchesCount > 0) {
                Icon icon = iconService.findByValue(ch);
                if (matchesCount == 2) {
                    bonus += icon.getTripleCost();
                }
                if (matchesCount == 1) {
                    bonus += icon.getDoubleCost();
                }
            }
        }
        int change = bonus * bet / 70;
        player.setBalance(player.getBalance() + change - bet);
        History history = new History();
        history.setResult(change);
        history.setBet(bet);
        history.setBalance(player.getBalance());
        history.setDateTime(LocalDateTime.now());
        history.setSlotId(slot.getId());
        history.setPlayer(player);
        historyService.save(history);
        player.getHistory().add(history);
        return change;
    }

    public List<String> getView(Slot slot) {
        List<String> result = new ArrayList<>();
        int[] state = slot.getState();
        List<String> rails = slot.getRails();
        for (int i = 0; i < ROWS_TO_SHOW; i++) {
            char[] chars = new char[state.length];
            for (int j = 0; j < state.length; j++) {
                int index = state[j] + i;
                String rail = rails.get(j);
                int length = rail.length();
                index %= length;
                chars[j] = rail.charAt(index);
            }
            result.add(new String(chars));
        }
        return result;
    }
}
