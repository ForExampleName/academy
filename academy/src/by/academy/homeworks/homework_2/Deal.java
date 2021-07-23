package by.academy.homeworks.homework_2;

import java.util.Random;
import java.util.Scanner;

public class Deal {
	private static final Scanner scanner = new Scanner(System.in);
	private static final Random random = new Random();

	private static final int ALL_CARDS_NUM = 52;
	private static final int SUIT_NUM = 4;
	private static final int ONE_SUIT_CARDS_NUM = 13;
	private static final int CARDS_FOR_ONE_PLAYER_COUNT = 5;
	private static final int FIRST_CARD_VALUE = 2;
	private static final int LAST_CARD_WITHOUT_NAME_VALUE = 10;

	private static final String[] SUIT_NAMES = { "Hearts", "Diamonds", "Clubs", "Spades" };
	private static final String[] CARDS_WITH_NAME = { "Jack", "Queen", "King", "Ace" };

	public static void main(String[] args) {

		String[] cards = new String[ALL_CARDS_NUM];

		StringBuilder currentCard = new StringBuilder();

		for (int i = 0; i < SUIT_NUM; i++) {
			for (int j = 0; j < ONE_SUIT_CARDS_NUM; j++) {

				if (j + FIRST_CARD_VALUE > LAST_CARD_WITHOUT_NAME_VALUE) {
					currentCard.append(CARDS_WITH_NAME[(j + FIRST_CARD_VALUE) % LAST_CARD_WITHOUT_NAME_VALUE - 1]);
				} else {
					currentCard.append(j + FIRST_CARD_VALUE);
				}

				currentCard.append(" of ");
				currentCard.append(SUIT_NAMES[i]);

				cards[i * ONE_SUIT_CARDS_NUM + j] = currentCard.toString();
				currentCard.delete(0, currentCard.length());
			}
		}

		System.out.print("Enter number of players: ");
		int playersCount = scanner.nextInt();

		if (playersCount < 2 || playersCount > 10) {
			System.out.println("Wrong number of players (must be 2-10)");
			scanner.nextLine();
			scanner.close();
			return;
		}

		int cardIndex;
		int randomBorder = ALL_CARDS_NUM;

		for (int i = 0; i < playersCount; i++) {
			for (int j = 0; j < CARDS_FOR_ONE_PLAYER_COUNT; j++) {
				cardIndex = random.nextInt(randomBorder);

				--randomBorder;

				System.out.print(cards[cardIndex]);

				if (j != CARDS_FOR_ONE_PLAYER_COUNT - 1) {
					System.out.print(" | ");
				}

				if (cardIndex != cards.length)
					System.arraycopy(cards, cardIndex + 1, cards, cardIndex, cards.length - cardIndex - 1);
			}
			System.out.println("\n");
		}

		scanner.close();
	}
}