
public class Location {
	int x;
	int y;
	
	public Location(int x,int y){
		this.x = x;
		this.y = y;
		
	}

	public void setLoc (int x ,int y){
		this.x = x;
		this.y = y;
	}

	public int[] getLoc(){
		
		 return new int[] {this.x, this.y};
		
	}
}
