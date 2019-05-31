package ua.com.hav.slotserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "slots")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;//slot machine name

    @ElementCollection
    @OrderColumn
    @JsonIgnore
    private int[] state;//current rail indices

    @ElementCollection
    @JsonIgnore
    private List<Integer> allowedBets;//allowed bet amounts

    @ElementCollection
    @JsonIgnore
    private List<String> patterns;//winning patterns

    @ElementCollection
    @JsonIgnore
    private List<String> rails;//icon configurations

}
