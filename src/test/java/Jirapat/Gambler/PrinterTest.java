package Jirapat.Gambler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrinterTest {

    @Test
    public void printATextShouldNotThrowAnyException() {
        Printer printer = new Printer();
        printer.print("test");
    }
}
