
public class GameEntry {
	
	private String name; 
	private int points;
	
	public GameEntry(String name, int points){
		this.name = name;
		this.points = points;
	}
	
	public int getPoints(){
		return points;
	}
	
	public String getName(){
		return name;
	}	
}
