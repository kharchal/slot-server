package ua.com.hav.slotserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "histories")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    private int result;
    private int bet;

    @JsonIgnore
    private int balance;

    @ManyToOne
    @JsonIgnore
    private Player player;

    private Long slotId;
}
