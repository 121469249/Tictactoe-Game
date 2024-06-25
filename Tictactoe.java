package Project;

import java.util.*;

public class Tictactoe {
							
	public static void main(String[] args) {
		
		date.clearchessboard();
		date.DividingLine();
		date.Rule();
		date.DividingLine();
		date.PrintChessboard();	
		System.out.println("chooes a play mode ");
		System.out.println("[1] 2 Player's game  [2] Play chess with computer");
		Scanner sc=new Scanner(System.in);
		if(sc.nextInt()==1) {
			date.TwoPlayers();
		}
		else {
			date.PlaywithAI();
		}
		
	}

}
