package exam01;

import java.util.ArrayList;

//Question 2
/*
        matchResult | playerMove | opponent
	------------------------------------
	tied        | rock       | rock
	tied        | paper      | paper
	tied        | scissors   | scissors
	------------------------------------
	won         | rock       | scissors
	won         | paper      | rock
	won         | scissors   | paper
	------------------------------------
	lost        | rock       | paper
	lost        | paper      | scissors
	lost        | scissors   | rock
 */
public class RockPaperScissors{
	/* Updates playerMoves to hold the moves of the opponent,
	   based off the matchResults of each match*/
	public static void deduceOpponentMoves(ArrayList<String> matchResults, ArrayList<String> playerMoves){ 
		//FILL IN THE IMPLEMENTATION HERE
        if (matchResults == null || playerMoves == null || matchResults.size() != playerMoves.size()) {
            throw new IllegalArgumentException("bad tournament");
        }
        for (int i=0; i < matchResults.size(); i++) {
            String tempResult = matchResults.get(i);
            String tempPlayerMove = playerMoves.get(i);
            if (!tempResult.equals("won") && !tempResult.equals("tied") && !tempResult.equals("lost")) {
                throw new IllegalArgumentException("invalid match results");
            }
            if (!tempPlayerMove.equals("rock") && !tempPlayerMove.equals("paper") && !tempPlayerMove.equals("scissors")) {
                throw new IllegalArgumentException("bad moves");
            }
        }
        for (int i=0; i < matchResults.size(); i++) {
            String tempResult = matchResults.get(i);
            String tempPlayerMove = playerMoves.get(i);
            if (tempResult.equals("tied")) {
                playerMoves.set(i, tempPlayerMove);
            } else if (tempResult.equals("lost")) {
                if (tempPlayerMove.equals("rock")) {
                    playerMoves.set(i, "paper");
                } else if (tempPlayerMove.equals("paper")) {
                    playerMoves.set(i, "scissors");
                } else {
                    playerMoves.set(i, "rock");
                }
            } else {
                if (tempPlayerMove.equals("rock")) {
                    playerMoves.set(i, "scissors");
                } else if (tempPlayerMove.equals("paper")) {
                    playerMoves.set(i, "rock");
                } else {
                    playerMoves.set(i, "paper");
                }
            }
        }
	}
}
