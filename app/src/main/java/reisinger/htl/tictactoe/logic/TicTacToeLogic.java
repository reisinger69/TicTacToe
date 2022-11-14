package reisinger.htl.tictactoe.logic;

import reisinger.htl.tictactoe.R;

public class TicTacToeLogic {

    private char[][] board = new char[3][3];
    private int counter;

    public TicTacToeLogic() {
        intzialiseBoard();
    }

    public void intzialiseBoard() {
        for (int q = 0; q < board.length; q++) {
            for (int i = 0; i < board.length; i++) {
                board[q][i] = ' ';
            }
        }
    }

    public void newBoard(int i, char c) {
        counter++;
        switch (i) {
            case R.id.bu1: board[0][0] = c;
            break;
            case R.id.bu2: board[1][0] = c;
                break;
            case R.id.bu3: board[2][0] = c;
                break;
            case R.id.bu4: board[0][1] = c;
                break;
            case R.id.bu5: board[1][1] = c;
                break;
            case R.id.bu6: board[2][1] = c;
                break;
            case R.id.bu7: board[0][2] = c;
                break;
            case R.id.bu8: board[1][2] = c;
                break;
            case R.id.bu9: board[2][2] = c;
                break;
        };
    }

    public int checkForWin() {

        for (int i = 0; i < board.length; i++) {
            if ((board[i][0] == 'x' && board[i][1] == 'x' &&board[i][2] == 'x')) {
                return -1;
            } else if ((board[i][0] == 'o' && board[i][1] == 'o' &&board[i][2] == 'o')) {
                return 1;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if ((board[0][i] == 'x' && board[1][i] == 'x' &&board[2][i] == 'x')) {
                return -1;
            } else if ((board[0][i] == 'o' && board[1][i] == 'o' &&board[2][i] == 'o')) {
                return 1;
            }
        }

        if ((board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x')) {
            return -1;
        } else if ((board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o')) {
            return 1;
        }

        if ((board[2][0] == 'x' && board[1][1] == 'x' && board[0][2] == 'x')) {
            return -1;
        } else if ((board[2][0] == 'o' && board[1][1] == 'o' &&board[0][2] == 'o')) {
            return 1;
        }

        if (counter==9) {
            return -3;
        }

        return -2;
    }
}
