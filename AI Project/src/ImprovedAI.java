public class ImprovedAI extends ConnectFourPlayer {
	
	public ImprovedAI(){
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
            
        int bestMove = 0;
        int bestScore = -1000000;
        
        for (int i = 0; i < moves.length; i++) {
        	int [][] newBoard = ConnectFourBoard.forecastMove(board, moves[i], player);
        	int score = evaluateBoard(newBoard, player);
        	
        	if (score > bestScore) {
        		bestScore = score;
        		bestMove = i;
        	}
        }
        return moves[bestMove];
    }
	
	private int evaluateBoard(int [][] board, int player) {
		int score = 0;
		//in a row
		for (int row = 0; row < board.length; row++) {
			
			for (int col = 0; col < board[row].length - 2; col++) {
				//2 in a row
				if ((board[row][col] == player && board[row][col + 1] == player && board[row][col + 2] != player)) {
					score = score + 50000;
				}
				
				if (board[row][col] == 3 - player && board[row][col + 1] == 3 - player && board[row][col + 2] != 3 - player) {
					score = score + -70000;
				}
				//3 in a row
				if (board[row][col] == player && board[row][col + 1] == player && board[row][col + 2] == player) {
					score = score + 100000;
				}
				
				if (board[row][col] == 3 - player && board[row][col + 1] == 3 - player && board[row][col + 2] == 3 - player) {
					score = score + -120000;
				}
			}
		}
		//in a column
		for (int row = 0; row < board.length - 2; row++) {
			
			for (int col = 0; col < board[row].length; col++) {
				//2 in a row
				if ((board[row][col] == player && board[row + 1][col] == player && board[row + 2][col] != player)) {
					score = score + 50000;
				}
				
				if (board[row][col] == 3 - player && board[row + 1][col] == 3 - player && board[row + 2][col] != 3 - player) {
					score = score + -70000;
				}
				//3 in a row
				if (board[row][col] == player && board[row + 1][col] == player && board[row + 2][col] == player) {
					score = score + 100000;
				}
				
				if (board[row][col] == 3 - player && board[row + 1][col] == 3 - player && board[row + 2][col] == 3 - player) {
					score = score + -120000;
				}
			}
		}
		//diagonally
		for (int row = 0; row < board.length - 2; row++) {
			
			for (int col = 0; col < board[row].length - 2; col++) {
				//2 in a row
				if ((board[row][col] == player && board[row + 1][col + 1] == player && board[row + 2][col+ 2] != player)) {
					score = score + 50000;
				}
				
				if (board[row][col] == 3 - player && board[row + 1][col + 1] == 3 - player && board[row + 2][col + 2] != 3 - player) {
					score = score + -70000;
				}
				// 3 in a row
				if (board[row][col] == player && board[row + 1][col + 1] == player && board[row + 2][col + 2] == player) {
					score = score + 100000;
				}
				
				if (board[row][col] == 3 - player && board[row + 1][col + 1] == 3 - player && board[row + 2][col + 2] == 3 - player) {
					score = score + -120000;
				}
			}
		}

		return score;
	}

}
