package ua.com.hav.slotserver.logic;

import lombok.Data;

@Data
public class Pair<X, Y> {

    private X x;
    private Y y;

    public Pair() {
    }

    public Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}
