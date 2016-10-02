package Jirapat.Gambler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@SpringBootApplication
public class PokerApplication {
	private static final String RESOURCE_PATH = "./src/main/resources/input_file.txt";

	public static void main(String[] args) throws FileNotFoundException {
		//SpringApplication.run(DemoApplication.class, args);

		FileReader fileReader = new FileReader(RESOURCE_PATH);
		BufferedReader reader = new BufferedReader(fileReader);
		IGameParser gameParser = new GameParser(reader);
		IPrinter printer = new Printer();
		IGamePrinter gamePrinter = new GamePrinter(printer);
		GameManager gameManager = new GameManager(gameParser, gamePrinter);
		gameManager.process();
	}
}
