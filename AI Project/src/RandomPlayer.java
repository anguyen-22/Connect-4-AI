/**
 * A simple AI that makes a random move each turn
 * Also includes an example of how to create a game and play ot
 */

public class RandomPlayer extends ConnectFourPlayer 
{
    
    public static void main(String [] args)
    {
        ConnectFourPlayer cpu = new SimpleAI();
        ConnectFourPlayer ourAI = new ImprovedAI();
        ConnectFourBoard board = new ConnectFourBoard(9, 7);
        board.play(cpu, ourAI, true, true);
        /*int wins = 0;
        int total = 0;
        int count = 0;
        for (int j = 0; j < 5; j++) {
        	for (int i = 0; i < 50; i++) {
            	if (board.play(cpu, ourAI, false, false) == 2) {
            		wins++;
            	}
            }
        	total += wins;
        	wins = 0;
        	count++;
        }
        int average = total / count;
        System.out.println("We won " + average + " out of 50 on average");*/
        
    }
    
    //returns a value between 0 and board.length
    //which corresponds to the column you want to put your piece in
    public int getMove(int [][] board, int player){
        int [] moves = ConnectFourBoard.getMoves(board);
        int m = (int) (moves.length * Math.random());
        return moves[m];
    }
}
