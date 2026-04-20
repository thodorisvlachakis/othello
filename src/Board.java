import java.util.ArrayList;
import java.util.Scanner;

public class Board extends Move {
	private int N;//������� �������/������ ��� ������->������������ �������
	private char[][] board;
	private char name;//�� ����� ��� ������
	
	public Board() {
		super();
		N=0;
		name=' ';
		board=null;
	}
	
	public Board(int N) {
		super();
		this.N=N;
		name='O';
		board=new char[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board[i][j]='.';
			}
		}
		//���������� ��� ������ 4 �������
		if(N%2==0) {
			//N->������
			int n=(N/2)-1;
			board[n][n]='X';
			board[n][n+1]='O';
			board[n+1][n]='O';
			board[n+1][n+1]='X';
		}
		else {
			//�->��������
			int n=N/2;
			board[n][n]='X';
			board[n][n+1]='O';
			board[n+1][n]='O';
			board[n+1][n+1]='X';
		}
		
	}
	
	public void printBoard() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(board[i][j] +"|");
				if(j==(N-1)) {
					System.out.print("\n");
				}
			}
		}
	}
	
	public char getWhosePiece() {
		return name;
	}
	
	public char getOpponentPiece() {
		if(name=='X') {
			return 'O';
		}
		else {
			return 'X';
		}
	}
	
	public void setCurrentPlayer(char player) {
		//������ � ������� ��� ��������� ��� �� name
		name=player;
	}
	
	public boolean validMove(int x, int y) {
		boolean b=false;
		//������� �� ������� ��� �����
		if(board[x][y]=='.') {
			//������� ����
			if(checkFlip(x-1,y,-1,0)) {
				b=true;
			}
			
			//������� ����
			else if(checkFlip(x+1,y,+1,0)) {
				b=true;
			}
			
			//������� ��������
			else if(checkFlip(x,y-1,0,-1)) {
				b=true;
			}
			
			//������� �����
			else if(checkFlip(x,y+1,0,+1)) {
				b=true;
			}
			
			//������� ����-��������
			else if(checkFlip(x-1,y-1,-1,-1)) {
				b=true;
			}
			
			//������� ����-��������
			else if(checkFlip(x+1,y-1,+1,-1)) {
				b=true;
			}
			
			//������� ����-�����
			else if(checkFlip(x-1,y+1,-1,+1)) {
				b=true;
			}
			
			//������� ����-�����
			else if(checkFlip(x+1,y+1,+1,+1)) {
				b=true;
			}
		}
		
			
		return b;
	}
	
	public boolean checkFlip(int x, int y, int dX, int dY) {
		boolean b=false;
		int i;
		int j;
		//������� ����
		if(dX<0 && dY==0) {
			i=0;
			//������ � '�' � � '�';
			if(name=='X') {
				while(x-i>=0 && board[x-i][y]=='O') {
					i++;
				}
				if(x-i>=0 && i!=0 && board[x-i][y]=='X') {
					b=true;
				}
			}
			else if(name=='O') {
				while(x-i>=0 && board[x-i][y]=='X') {
					i++;
				}
				if(x-i>=0 && i!=0 && board[x-i][y]=='O') {
					b=true;
				}
			}
		}
		
		//������� ����
		else if(dX>0 && dY==0) {
			i=0;
			//������ � '�' � � '�';
			if(name=='X') {
				while(x+i<N && board[x+i][y]=='O') {
					i++;
				}
				if(x+i<N && i!=0 && board[x+i][y]=='X') {
					b=true;
				}
			}
			else if(name=='O') {
				while(x+i<N && board[x+i][y]=='X') {
					i++;
				}
				if(x+i<N && i!=0 && board[x+i][y]=='O') {
					b=true;
				}
			}
		}	
			//������� ��������
		else if(dX==0 && dY<0) {
				i=0;
				//������ � '�' � � '�';
				if(name=='X') {
					while(y-i>=0 && board[x][y-i]=='O') {
						i++;
					}
					if(y-i>=0 && i!=0 && board[x][y-i]=='X') {
						b=true;
					}
				}
				else if(name=='O') {
					while(y-i>=0 && board[x][y-i]=='X') {
						i++;
					}
					if(y-i>=0 && i!=0 && board[x][y-i]=='O') {
						b=true;
					}
				}
			}
			
			//������� �����
		else if(dX==0 && dY>0) {
				i=0;
				//������ � '�' � � '�';
				if(name=='X') {
					while(y+i<N && board[x][y+i]=='O') {
						i++;
					}
					if(y+i<N && i!=0 && board[x][y+i]=='X') {
						b=true;
					}
				}
				else if(name=='O') {
					while(y+i<N && board[x][y+i]=='X') {
						i++;
					}
					if(y+i<N && i!=0 && board[x][y+i]=='O') {
						b=true;
					}
				}
		}
			
			//������� ����-��������
		else if(dX<0 && dY<0) {
				i=0;
				j=0;
				//������ � '�' � � '�';
				if(name=='X') {
					while(x-i>=0 && y-j>=0 && board[x-i][y-j]=='O') {
						i++;
						j++;
					}
					if(i!=0 && j!=0 && x-i>=0 && y-j>=0 && board[x-i][y-j]=='X') {
						b=true;
					}
				}
				else if(name=='O') {
					while(x-i>=0 && y-j>=0 && board[x-i][y-j]=='X') {
						i++;
						j++;
					}
					if(i!=0 && j!=0 && x-i>=0 && y-j>=0 && board[x-i][y-j]=='O') {
						b=true;
					}
				}
			}
			
			//������� ����-�����
		else if(dX<0 && dY>0) {
				i=0;
				j=0;
				//������ � '�' � � '�';
				if(name=='X') {
					while(x-i>=0 && y+j<N && board[x-i][y+j]=='O') {
						i++;
						j++;
					}
					if(i!=0 && j!=0 && x-i>=0 && y+j<N && board[x-i][y+j]=='X') {
						b=true;
					}
				}
				else if(name=='O') {
					while(x-i>=0 && y+j<N && board[x-i][y+j]=='X') {
						i++;
						j++;
					}
					if(i!=0 && j!=0 && x-i>=0 && y+j<N && board[x-i][y+j]=='O') {
						b=true;
					}
				}
			}
			
			//������� ����-��������
		else if(dX>0 && dY<0) {
				i=0;
				j=0;
				//������ � '�' � � '�';
				if(name=='X') {
					while(x+i<N && y-j>=0 && board[x+i][y-j]=='O') {
						i++;
						j++;
					}
					if(i!=0 && j!=0 && x+i<N && y-j>=0 && board[x+i][y-j]=='X') {
						b=true;
					}
				}
				else if(name=='O') {
					while(x+i<N && y-j>=0 && board[x+i][y-j]=='X') {
						i++;
						j++;
					}
					if(i!=0 && j!=0 && x+i<N && y-j>=0 && board[x+i][y-j]=='O') {
						b=true;
					}
				}
			}
			
			//������� ����-�����
		else if(dX>0 && dY>0) {
				i=0;
				j=0;
				//������ � '�' � � '�';
				if(name=='X') {
					while(x+i<N && y+j<N && board[x+i][y+j]=='O') {
						i++;
						j++;
					}
					if(i!=0 && j!=0 && x+i<N && y+j<N && board[x+i][y+j]=='X') {
						b=true;
					}
				}
				else if(name=='O') {
					while(x+i<N && y+j<N && board[x+i][y+j]=='X') {
						i++;
						j++;
					}
					if(i!=0 && j!=0 && x+i<N && y+j<N && board[x+i][y+j]=='O') {
						b=true;
					}
				}
			}
		
		return b;
	}
	
	public void flipPieces(int x, int y, int dX, int dY) {
		if(checkFlip(x,y,dX,dY)) {
			int a=0;
			int b=0;
			if(name=='X') {
				while(board[x+a*dX][y+b*dY]=='O') {
					board[x+a*dX][y+b*dY]='X';
					a++;
					b++;
					if(x+a*dX<0 || x+a*dX>N || y+b*dY<0 || y+b*dY>N)
						break;
				}
			}
			
			else if(name=='O') {
				while(board[x+a*dX][y+b*dY]=='X') {
					board[x+a*dX][y+b*dY]='O';
					a++;
					b++;
					if(x+a*dX<0 || x+a*dX>N || y+b*dY<0 || y+b*dY>N)
						break;
				}
			}
		}
		
		/*else {
			System.out.println("This flip can't be done");
		}*/
	}
	
	public void makeMove(int x, int y) {
		if(validMove(x,y)) {
			if(name=='X') {
				board[x][y]='X';
			}
			else {
				board[x][y]='O';
			}
			//������� ����
			if(checkFlip(x-1,y,-1,0)) {
				flipPieces(x-1,y,-1,0); 
			}
			
			//������� ����
			if(checkFlip(x+1,y,+1,0)) {
				flipPieces(x+1,y,+1,0);
			}
			
			//������� ��������
			if(checkFlip(x,y-1,0,-1)) {
				flipPieces(x,y-1,0,-1);
			}
			
			//������� �����
			if(checkFlip(x,y+1,0,+1)) {
				flipPieces(x,y+1,0,+1);
			}
			
			//������� ����-��������
			if(checkFlip(x-1,y-1,-1,-1)) {
				flipPieces(x-1,y-1,-1,-1);
			}
			
			//������� ����-��������
			if(checkFlip(x+1,y-1,+1,-1)) {
				flipPieces(x+1,y-1,+1,-1);
			}
			
			//������� ����-�����
			if(checkFlip(x-1,y+1,-1,+1)) {
				flipPieces(x-1,y+1,-1,+1);
			}
			
			//������� ����-�����
			if(checkFlip(x+1,y+1,+1,+1)) {
				flipPieces(x+1,y+1,+1,+1);
			}
		}
		
		else {
			System.out.println("Invalid move. Enter move again");
		}
		
	}
	
	public boolean gameOver() {
		//return true if the game is over
		boolean b=true;
		
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(board[i][j]=='.') {
						//check if move in [i,j] is valid.
						if(validMove(i,j)) {
							b=false;
						}
					}
					if(b==false)
						break;
				}
				if(b==false)
					break;
			}
			if(b==true) {
				//check the second player
				setCurrentPlayer(getOpponentPiece());
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(board[i][j]=='.') {
							//check if move in [i,j] is valid.
							if(validMove(i,j)) {
								b=false;
							}
						}
						if(b==false)
							break;
					}
					if(b==false)
						break;
				}
				//bring back the first player as the current player
				setCurrentPlayer(getOpponentPiece());
			}
		
		return b;
	}
	
	public int score(char piece) {
		int score=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j]==piece) {
					score++;
				}
			}
		}
		
		return score;
	}
	
	ArrayList<Move> getMoveList(char piece){
		ArrayList<Move> moveList=new ArrayList<Move>();
		Move validMove=new Move();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(validMove(i,j)) {
					validMove=new Move(i,j);
					moveList.add(validMove);
				}
			}
		}
		
		return moveList;
	}
	
	public Move getFirstMove(ArrayList<Move> possibleMoves) {
		return possibleMoves.get(0);
	}
	
	
	
	public static void main(String[] args) {
		Board gameBoard=new Board(6);
		
		//Check if the game is over
		do {
			gameBoard.printBoard();
			
			//Player X's turn or Player O's turn?
			if(gameBoard.getWhosePiece()=='O') {
				gameBoard.setCurrentPlayer('X');
			}
			else {
				gameBoard.setCurrentPlayer('O');
			}
			
			System.out.println("It is player " +gameBoard.getWhosePiece() +"'s turn.");
			
			
			//Check if player 'X' or player 'O' has no other valid moves
			boolean a=false;
			for(int i=0;i<6;i++) {
				for(int j=0;j<6;j++) {
					if(gameBoard.validMove(i,j)) {
						a=true;
					}
					if(a==true)
						break;
				}
				if(a==true)
					break;
			}
			if(a==false) {
				System.out.println("Player "+gameBoard.getWhosePiece()+" has no other moves.");
			}
			
			else {
				if(gameBoard.getWhosePiece()=='X') {
					int n=1;
					for(int g=0;g<n;g++) {
						Scanner in1=new Scanner(System.in);
						Scanner in2=new Scanner(System.in);
						System.out.println("Enter move.");
						System.out.print("Enter the horizontal coordinate: ");
						int x=in1.nextInt();
						System.out.print("Enter the vertical coordinate: ");
						int y=in2.nextInt();
						
						if(gameBoard.validMove(x, y)==false) {
							System.out.println("Invalid move. Enter move again");
							n++;
						}
						else {
							gameBoard.makeMove(x, y);
						}
					}
					
				}
				else {
					int x,y;
					
					ArrayList<Move> possibleMovesForO;
					possibleMovesForO=gameBoard.getMoveList('O');
					
					Move move=new Move();
					move=gameBoard.getFirstMove(possibleMovesForO);
					x=move.getX();
					y=move.getY();
					
					gameBoard.makeMove(x, y);
				}
				
			}
		} while(gameBoard.gameOver()==false);
		
		System.out.println("The game is over!");
		System.out.println("X Player's Score: " +gameBoard.score('X') );
		System.out.println("O Player's Score: " +gameBoard.score('O') );
		
	}
	
}