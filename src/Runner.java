import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws Exception{

		Scoreboard board = new Scoreboard();
		Scanner in = new Scanner(System.in);

// 		Base players
		board.addGameEntry(new GameEntry("Pedro", 1000));

		board.addGameEntry(new GameEntry("Maria", 2000));

		board.addGameEntry(new GameEntry("Ruben", 500));

		board.addGameEntry(new GameEntry("Mario", 5000));

		board.addGameEntry(new GameEntry("Vanesa", 100));

		board.sortScores();


		boolean quit = false;
		while(!quit){
			
			System.out.println("Menu: ");
			System.out.println("1. Add a new player.");
			System.out.println("2. Show the player in a the specific rank.");
			System.out.println("3. Show the rank of an specific player.");
			System.out.println("4. Show the Scoreboard.");
			System.out.println("5. Remove a player.");
			System.out.println("6. Exit.");
			System.out.println("What is your choice?");
			
			int decision = in.nextInt();
			
			switch(decision) {

			case 1:
				System.out.println("What is the name of the player?");
				String name = in.next();
				
				System.out.println("How much points the player has?");
				int points = in.nextInt();

				board.addGameEntry(new GameEntry(name, points));

				System.out.println("The player has been added.");
				System.out.println();
				
				board.sortScores();

				break;

			case 2:
				System.out.println("What is the rank of the player?");
				int rank = in.nextInt();
				System.out.println(board.getName(rank) + " has the rank " + rank + " with " + board.getPoints(rank) + " points.");
				System.out.println();

				break;

			case 3:
				System.out.println("What is the name of the player?");
				String target = in.next();
				System.out.println(target + " has the rank " + board.getRank(target) + " with " + 
				board.getPoints(board.getRank(target)) + " points.");
				System.out.println();
				
				break;

			case 4:
				board.printScoreboard();
				System.out.println();
				
				break;

			case 5:
				System.out.println("What is the name of the player?");
				String remove = in.next();
				
				board.removePlayer(remove);
				
				System.out.println("The player has been removed.");
				System.out.println();
				
				board.founded = false;
								
				break;
			case 6:
				quit = true;
				System.out.println("Thanks for your time.");
				break;

			default:
				System.out.println("The option that you select is not avalible. Please select another option.");
				System.out.println();
				break;
			}
		}		
	}
}
