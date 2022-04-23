package src.main;

import java.util.Scanner;

public class Util {

	public static final Scanner scanner = new Scanner(System.in);

	public static int askAmount() {
		System.out.print(" How much? ");
		return getAmount();
	}

	public static int getAmount() {
		try {
			int value = scanner.nextInt();
			scanner.nextLine(); // Consume the whole line
			return value;
		} catch (Exception e) {
			System.out.println("Invalid Number!");
		}
		return 0;
	}

	public static void sleep(int ms) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// ! HACK: i don't want to deal with it
		}
	}

}
