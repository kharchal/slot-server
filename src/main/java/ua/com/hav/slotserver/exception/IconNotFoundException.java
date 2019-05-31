package ua.com.hav.slotserver.exception;

public class IconNotFoundException extends RuntimeException {

    public IconNotFoundException() {
    }

    public IconNotFoundException(char s) {
        super("Icon for value = " + s + " not found");
    }
}
