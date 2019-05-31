package ua.com.hav.slotserver.view;

import lombok.Data;

import java.util.List;

@Data
public class BetResult {
    private int prize;
    private int balance;
    private List<String> state;
}
