package by.academy.homeworks.homework_2;

import java.util.Random;
import java.util.Scanner;

public class Deal {
	private static final Scanner scanner = new Scanner(System.in);
	private static final Random random = new Random();

	private static final int ALL_CARDS_NUM = 52;
	private static final int SUIT_NUM = 4;
	private static final int ONE_SUIT_CARDS_NUM = 13;
	private static final int CARDS_COUNT_FOR_ONE_PLAYER = 5;
	private static final int CORRECTION = 2;

	private static final String[] SUIT_NAMES = { "Hearts", "Diamonds", "Clubs", "Spades" };
	private static final String[] SPECIAL_CARDS = { "Jack", "Queen", "King", "Ace" };

	public static void main(String[] args) {

		String[] cards = new String[ALL_CARDS_NUM];
		StringBuilder currentCard = new StringBuilder();

		for (int i = 0; i < SUIT_NUM; i++) {
			for (int j = 0; j < ONE_SUIT_CARDS_NUM; j++) {
				currentCard.delete(0, currentCard.length());

				if (j + CORRECTION > 10) {
					currentCard.append(SPECIAL_CARDS[(j + CORRECTION) % 10 - 1]);
				} else {
					currentCard.append(j + CORRECTION);
				}

				currentCard.append(" of ");
				currentCard.append(SUIT_NAMES[i]);
				cards[i * ONE_SUIT_CARDS_NUM + j] = currentCard.toString();
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
			for (int j = 0; j < CARDS_COUNT_FOR_ONE_PLAYER; j++) {
				cardIndex = random.nextInt(randomBorder);
				--randomBorder;
				System.out.print(cards[cardIndex]);
				if (j != CARDS_COUNT_FOR_ONE_PLAYER - 1) {
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