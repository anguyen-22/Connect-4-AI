public class LessSimpleAI extends ConnectFourPlayer {
	
	public LessSimpleAI(){
	    return;
    }
	
	public int getMove(int [][] board, int player){
        int[] moves = ConnectFourBoard.getMoves(board);
        for (int i = 0; i < moves.length; i++) {
        	int[][] newBoard = ConnectFourBoard.forecastMove(board, moves[i], player);
        	
        	if (ConnectFourBoard.hasWinner(newBoard) == player) {
        		return moves[i];
        	}
        	
        	newBoard = ConnectFourBoard.forecastMove(board, moves[i], 3 - player);
        	
        	if (ConnectFourBoard.hasWinner(newBoard) == 3 - player) {
        		return moves[i];
        	}
        }
        int m = (int) (Math.random() * moves.length);
        return moves[m];
    }

}
