package Jirapat.Gambler;

/**
 This class is responsible for printing text on console application.
 */
public class Printer implements IPrinter {

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
