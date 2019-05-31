package ua.com.hav.slotserver.exception;

public class SlotNotFoundException extends RuntimeException {

    public SlotNotFoundException() {
    }

    public SlotNotFoundException(Long id) {
        super("Slot with id = " + id + " not found");
    }
}
