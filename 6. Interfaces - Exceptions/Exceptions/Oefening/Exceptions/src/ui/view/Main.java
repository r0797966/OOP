package ui.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Geef getal");
        String divisor = new BufferedReader(new InputStreamReader(System.in)).readLine();
        try {
            System.out.println(3/Integer.parseInt(divisor));
        } catch (UIException e){
            System.out.println(e.getMessage());
            System.out.println(e);
        } catch (NumberFormatException e){
            System.out.println("Integer.parseInt werkt niet voor lege string");
        }
    }
}
