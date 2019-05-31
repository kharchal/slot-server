package ua.com.hav.slotserver.exception;

public class NotEnoughMoneyException extends RuntimeException {

    public NotEnoughMoneyException() {
    }

    public NotEnoughMoneyException(Integer bet) {
        super("the player is short of money: " + bet);
    }
}
