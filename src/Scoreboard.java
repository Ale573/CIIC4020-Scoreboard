import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Scoreboard{
	
	ArrayList<GameEntry> scores = new ArrayList<GameEntry>();

	public Scoreboard() {}
	
	public void addGameEntry(GameEntry entry) throws Exception{
		
		for(int i = 0; i < scores.size(); i++){
			if(scores.get(i).getName().equals(entry.getName())){
				throw new Exception("The name is already in use.");
			}
		}
		scores.add(entry);
	}
	
	public void sortScores(){
		
		Collections.sort(scores, new Comparator <GameEntry>() {
			public int compare(GameEntry entry1, GameEntry entry2) {
				return Integer.compare(entry1.getPoints(), entry2.getPoints());
			}
		});
		
		Collections.reverse(scores);
	}
	
	public String getName(int rank){
		return scores.get(rank - 1).getName();
	}
	
	public int getRank(String name) throws Exception{
	
		for(int i = 0; i < scores.size(); i++){
			if(scores.get(i).getName().equals(name)){
				return (i + 1);
			}
		}
		throw new Exception("The player " + name + " is not in the Scoreboard.");
	}
	
	public int getPoints(int rank){
		return scores.get(rank - 1).getPoints();
	}
	
	public void printScoreboard() throws Exception{
		
		if(scores.isEmpty()){
			throw new Exception("The Scoreboard is empty.");
		}

		// The %-4d is to reserve that space for 4 digits. The same with the others.
		// The %n represent lines separator sequence.
		String leftAligment = "|  %-2d  | %-12s | %-6d |%n";
		
		System.out.format("+------+--------------+--------+%n");
		System.out.format("| Rank | Player       | Points |%n");
		System.out.format("+------+--------------+--------+%n");
		
		for(int i = 0; i < scores.size(); i++){

			System.out.format(leftAligment, (i + 1) , scores.get(i).getName() , scores.get(i).getPoints());
		}
		
		System.out.format("+------+--------------+--------+%n");
	}
}