package ua.com.hav.slotserver.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "icons")
public class Icon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private char value;//icon char
    private int doubleCost;//winning prize for two icons
    private int tripleCost;//winning prize for three icons
}
