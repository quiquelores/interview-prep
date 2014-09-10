
public class connect4 {
	boolean verbose = true;
	final int WINNER = -100;

	int[][] board = new int[7][7];
	
	final int empty = 0;
	final int playerOne = 1;
	final int playerTwo = 2;
	int turn = playerOne;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		connect4 testgame = new connect4();
		testgame.newGame();
		
		testgame.add(0);
		testgame.add(1);
		testgame.add(0);
		testgame.add(1);
		testgame.add(0);
		testgame.add(1);
		testgame.add(0);
		testgame.add(1);
		testgame.add(0);	
	}
	public void newGame(){
		for(int i = 0; i<this.board.length;i++){
			for(int j=0; j<this.board[i].length;j++){
				this.board[i][j] = empty;
			}
		}
	}
	public void changeTurn(){
		if(turn == playerOne){
			turn = playerTwo;
			return;
		}
		turn = playerOne;
	}
	
	public int checkWinner(int posX, int posY){
		if(posX < 0 || posX > 7 || posY < 0 || posY > 7){
			System.out.println("HHHH");
			return -1;
		}
		int player = board[posX][posY];
			for(int i = 0; i< 4; i++){
				int dirX = 0; 
				int dirY = 1;
				
				if(i>0){
					dirX = 1;
				}
				if(i==2){
					dirY = 0;
				}
				int cwr = checkWinnerRecurs(posX, posY, player, 0, dirX, dirY) + 1 + checkWinnerRecurs(posX, posY, player, 0, -dirX, -dirY);
			if(checkWinnerRecurs(posX, posY, player, 0, dirX, dirY) + 1 + checkWinnerRecurs(posX, posY, player, 0, -dirX, -dirY) >= 4){
				return player;
			}
			System.out.println("CWR: " + cwr );

		}
		return -1;
	}
	public int checkWinnerRecurs(int posX, int posY, int player, int count, int dirX, int dirY){
		if(posX + dirX < 0 || posX + dirX > 7 || posY + dirY < 0 || posY + dirY > 7){
			if(verbose){
				System.out.println("CheckWinnerRecurs: Reached side of board. Count = "+ count + ". Position = (" + posX + ", " + posY 
						+ "). Direction = (" + dirX + ", " + dirY + ").");
			}
			return count;
		}
		if(board[posX+dirX][posY+dirY]==player){
			return checkWinnerRecurs(posX+dirX, posY+dirY, player, count +1, dirX, dirY);
		}
		return count;
	}

	public int add(int x){
		int y = 0;
		while(board[x][y]!= empty && y <= 7){
			y++;
		}
		if(y==7 && board[x][y]!=empty){
			return -1;
		}
		board[x][y] = turn;
		if(checkWinner(x,y) == turn){
			System.out.println("WINNER");
			return WINNER;
		}
		printGame();
		System.out.println("CHECKWINNER? : " + checkWinner(x,y));
		this.changeTurn();
		return y;
	}
	
	public void printGame(){
		for(int i = board.length-1; i>=0; i--){
			for(int j = 0; j<board.length; j++){
				System.out.print("[" + board[j][i] + "]");
			}
			System.out.println();
		}
		System.out.println("Turn: " + turn);
	}

}
