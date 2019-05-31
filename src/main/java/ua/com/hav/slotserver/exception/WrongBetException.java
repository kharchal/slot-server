package ua.com.hav.slotserver.exception;

public class WrongBetException extends RuntimeException {

    public WrongBetException() {
    }

    public WrongBetException(Integer bet) {
        super("Bet must be allowed: " + bet);
    }
}
