package ua.com.hav.slotserver.view;

import lombok.Data;

import java.util.List;

@Data
public class SlotInfo {
    private Long id;
    private String name;
    private List<String> state;
    private List<String> rails;
    private List<String> patterns;
}
