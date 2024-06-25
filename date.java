package Project;

import java.util.Scanner;

public class date {
	
	static int piece[][]=new int[3][3];
	static int position;
	static int playerNum;
		
	static void clearchessboard() {		
		for (int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				piece[i][j]=0;
			}
		}
	}
	
	static void DividingLine() {
		System.out.println("----------------------------------------------------------------------------------------");
	}
	
	static void Rule() {
		System.out.println("Rules:");
		System.out.println("It is a Tictactoe game for one or two players by Java.\r\nplayer 1's piece is 1, player 2's piece is 2. \r\n0 means there are no pieces.");
		System.out.println("Enter two-digits number to drop a piece.");
		System.out.println("The first digit of a number represent the row on the board.");
		System.out.println("The second digit of a number represents the column on the board.");
		System.out.println("e.g. 22 is the middle of the chessboard. 11 is the upper left corner of the chessboard"); 
		System.out.println("When one player¡¯s pieces are three in a row or in a slant, or in a column. That player wins. \r\nOr when the chessboard is full, but the winning rule is not triggered. It is a draw.");
	}
	
	static void PrintChessboard() {
		for (int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(piece[i][j]);
				System.out.print("|");
			}
			System.out.println("");			
		}
	}
	
	static void DropPiece(int p) {
		while(p!=11&p!=12&p!=13&p!=21&p!=22&p!=23&p!=31&p!=32&p!=33 || piece[p/10-1][p%10-1]!=0) {			
			System.out.println("The selected position does not conform to the rules, please enter again!");
			Scanner input=new Scanner(System.in);
			position=input.nextInt();
			p=position;				
		}
		piece[p/10-1][p%10-1]=playerNum;			
	}
	
	static void AIDropPiece() {	
		boolean f=false;
		String ai="";
		for (int i=0;i<3;i++) {			
			if(piece[i][0]==0&piece[i][1]==1&piece[i][2]==1) {
				piece[i][0]=playerNum;
				ai=i+"1";
				f=true;
				break;
			}
			else if(piece[i][0]==1&piece[i][1]==0&piece[i][2]==1){
				piece[i][1]=playerNum;
				ai=i+"2";
				f=true;	
				break;
				}
		    else if(piece[i][0]==1&piece[i][1]==1&piece[i][2]==0){
				piece[i][2]=playerNum;
				ai=i+"3";
				f=true;
				break;
			}	
					
		}		
						
		if(!f) {
			for (int i=0;i<3;i++) {			
				if(piece[0][i]==0&piece[1][i]==1&piece[2][i]==1) {
					piece[0][i]=playerNum;
					ai="1"+i;
					f=true;
					break;
				}
				else if(piece[0][i]==1&piece[1][i]==0&piece[2][i]==1){
					piece[1][i]=playerNum;
					ai="2"+i;
					f=true;	
					break;
					}
			    else if(piece[0][i]==1&piece[1][i]==1&piece[2][i]==0){
					piece[2][i]=playerNum;
					ai="3"+i;
					f=true;
					break;
				}	
						
			}
		}
		if(!f) {
			if(piece[0][0]==0&piece[1][1]==1&piece[2][2]==1) {
				piece[0][0]=playerNum;
				ai="11";
				f=true;				
			}
			else if(piece[0][0]==1&piece[1][1]==0&piece[2][2]==1){
				piece[1][1]=playerNum;
				ai="22";
				f=true;		
			}
			else if(piece[0][0]==1&piece[1][1]==1&piece[2][2]==0){
				piece[2][2]=playerNum;
				ai="33";
				f=true;
			}			
		}
		if(!f) {
			if(piece[1][1]==0&piece[0][2]==1&piece[2][0]==1) {
				piece[1][1]=playerNum;
				ai="22";
				f=true;				
			}
			else if(piece[1][1]==1&piece[0][2]==0&piece[2][0]==1){
				piece[0][2]=playerNum;
				ai="13";
				f=true;		
			}
			else if(piece[1][1]==1&piece[0][2]==1&piece[2][0]==0){
				piece[2][0]=playerNum;
				ai="31";
				f=true;
			}
		}
		if(!f) {
			int p=0;
			while(p!=11&p!=12&p!=13&p!=21&p!=22&p!=23&p!=31&p!=32&p!=33 || piece[p/10-1][p%10-1]!=0) {
				p=(int)(Math.random()*4)*10+(int)(Math.random()*4);				
			}
			piece[p/10-1][p%10-1]=playerNum;
			ai=Integer.toString(p);
		}
		System.out.println("Player 2(computer) choose to drop the piece in "+ai);
			
	}
	
	static boolean VictoryJudgment() {
		boolean flag=false;
		for (int i=0;i<3;i++) {
			if(piece[i][0]==playerNum && piece[i][1]==playerNum &&piece[i][2]==playerNum) {
				System.out.println("Player "+playerNum+" wins!");
				flag=true;
				break;
			}
		}
		for (int i=0;i<3;i++) {
			if(piece[0][i]==playerNum && piece[1][i]==playerNum &&piece[2][i]==playerNum) {
				System.out.println("Player "+playerNum+" wins!");
				flag=true;
				break;
			}
		}
		if(piece[0][0]==playerNum && piece[1][1]==playerNum &&piece[2][2]==playerNum||piece[0][2]==playerNum && piece[1][1]==playerNum &&piece[2][0]==playerNum) {
			System.out.println("Player "+playerNum+" wins!");
			flag=true;			
		}
		return flag;
	}
	
	public static void TwoPlayers() {
		System.out.println("This mode is for two players to play.");
		Scanner input=new Scanner(System.in);
		for(int i=0;i<9;i++){			
			DividingLine();
			System.out.println("It is player "+ (i%2+1) +"'s round. Enter the position you want to drop the piece");			
			DividingLine();
			playerNum=i%2+1;
			position=input.nextInt();				
			DropPiece(position);
			PrintChessboard();
			if (VictoryJudgment()) {
				break;
			}
			if(i==8) {
				System.out.println("It is a draw");
			}
		}
	}
	
	public static void PlaywithAI() {
		System.out.println("This mode is for one player to play, and the computer acts as the second player.");
		Scanner input=new Scanner(System.in);
		for(int i=0;i<9;i++){			
			DividingLine();
			if(i%2==0) {	
				System.out.println("It is your round. Enter the position you want to drop the piece");				
				DividingLine();
				playerNum=i%2+1;
				position=input.nextInt();				
				DropPiece(position);
				PrintChessboard();
				if (VictoryJudgment()) {
					break;
				}
				if(i==8) {
					System.out.println("It is a draw");
				}
			}
			else {
				System.out.println("It is computer's round.");
				DividingLine();
				playerNum=i%2+1;
				AIDropPiece();
				PrintChessboard();
				if (VictoryJudgment()) {
					break;
				}
				if(i==8) {
					System.out.println("It is a draw");
				}
		    }						
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
