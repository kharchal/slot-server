package ua.com.hav.slotserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;//player name
    private int balance;//player balance

    @OneToMany(mappedBy = "player")
    @JsonIgnore
    private List<History> history = new ArrayList<>();//statistic data
}
