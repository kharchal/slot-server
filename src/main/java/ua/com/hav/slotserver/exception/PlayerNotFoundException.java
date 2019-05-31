package ua.com.hav.slotserver.exception;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException() {
    }

    public PlayerNotFoundException(Long id) {
        super("Player with id = " + id + " not found!");
    }
}
