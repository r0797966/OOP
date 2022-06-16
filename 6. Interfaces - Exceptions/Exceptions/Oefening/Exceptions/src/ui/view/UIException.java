package ui.view;

public class UIException extends RuntimeException{

    public UIException(String message) {
        super(message);
        System.out.println("Ik gooide mijn eigen UIException!");
    }
}
