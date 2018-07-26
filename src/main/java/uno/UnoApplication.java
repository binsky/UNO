package uno;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uno.game.Game;
import uno.game.cards.Card;
import uno.game.cards.Deck;
import uno.game.cards.Hand;
import uno.game.cards.Utils;

@SpringBootApplication
public class UnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnoApplication.class, args);
		
		Game game = new Game();
		
		game.startGame(3);
		
	}
}
