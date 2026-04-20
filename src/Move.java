public class Move {
	//coordinates of last move
	private int x;
	private int y;
	
	public Move() {
		x=0;
		y=0;
	}
	
	public Move(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
}