import java.util.Scanner;
import com.zubiri.Hangman;
public class LazkanoHangman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the famous HANGMAN game.");
		System.out.println("You will have to guess which surname of the people in class is hidden between the voids.");
		System.out.println(
				"For this, you will be able to enter 3 letters that may appear in the surname, or not. After this, you will only have a chance to guess the surname and win the game.");
		boolean playAgain = true;
		while (playAgain == true) {
			Hangman game = new Hangman();
			game.setSurname(game.selectSurname());
			game.printSelectedSurname();
			while (game.getTries() < 3) {
				String entered[] = sc.nextLine().toLowerCase().split(" ");
				char playerLetter = entered[0].charAt(0);
				game.checkLetter(playerLetter);
				game.printSelectedSurname();
				if (game.getTries() == 1) {
					System.out.println("You have two letters left.");
				} else if (game.getTries() == 2) {
					System.out.println("You have just a letter left.");
				}
			}
			System.out.println("It's the time, you have to guess the word.");
			boolean wordEntered = false;
			while (wordEntered == false) {
				String[] playerWordArray = sc.nextLine().split(" ");
				String surnameEntered=playerWordArray[0];
				if (game.playerWord(surnameEntered)){
					System.out.println("Congrats, you won the game.");
				}else {
					System.out.println("I'm sorry, you lost the game.");
				}
				wordEntered=true;
			}
			System.out.println("Would you like to play again?(y/n)");
			boolean askAgain = true;
			while (askAgain == true) {
				String back = sc.next().toLowerCase();
				sc.nextLine();
				switch (back) {
				case "y":
					askAgain = false;
					break;
				case "n":
					playAgain = false;
					askAgain = false;
					break;
				default:
					System.out.println("Please, select a possible value(y/n)");
					break;
				}
			}
		}
		sc.close();
	}

}