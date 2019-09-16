package board;

import java.util.HashMap;
import java.util.Scanner;

public class Board {

    // Constructor of Board
    public Board(){
        System.out.println("Let the game begin! This is the playboard. Please enter the number where you want to set your sign.");
    }

    // Create object scanner 
    Scanner scanner = new Scanner(System.in); 

    //This is the initalization and declaration of two dimensional array, called: boardarray.
    private final String[][] boardArray = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

    //This is the initalization and declaration of the hasmapper, called: boardmapper.
    private final HashMap<Integer, int[]> boardMapper = new HashMap<>();

    //This method will draw the board 
    public String drawBoard() {
        fillBoard();
        return "\n" +
                " " + boardArray[0][0] + " | " + boardArray[0][1] + " | " + boardArray[0][2] + " \n" +
                "------------\n" +
                " " + boardArray[1][0] + " | " + boardArray[1][1] + " | " + boardArray[1][2] + " \n" +
                "------------\n" +
                " " + boardArray[2][0] + " | " + boardArray[2][1] + " | " + boardArray[2][2] + " \n";
    }

    // This method will map the known values to the board 
    private void fillBoard() {

        boardMapper.put(1, new int[]{0, 0});
        boardMapper.put(2, new int[]{0, 1});
        boardMapper.put(3, new int[]{0, 2});
        boardMapper.put(4, new int[]{1, 0});
        boardMapper.put(5, new int[]{1, 1});
        boardMapper.put(6, new int[]{1, 2});
        boardMapper.put(7, new int[]{2, 0});
        boardMapper.put(8, new int[]{2, 1});
        boardMapper.put(9, new int[]{2, 2});

    }

    //This method will map the number of choice to the board 
    public void setSign(int number, String sign) {
        int[] pos = boardMapper.get(number);
        boardArray[pos[0]][pos[1]] = sign;
    }

    //This method will check if the number is already set on the board.
    public boolean isNumberSet(int number) {
        int[] pos = boardMapper.get(number);
        String c = boardArray[pos[0]][pos[1]];
        return c.equalsIgnoreCase("X") || c.equalsIgnoreCase("O");
    }

    //This method will calculate if there is already a winner. This calcultion is based on if there is a row with three "X"'s or "O"'s
    public String getWinner(String signPlayer1, String signPlayer2) {
        
        String winnerPlayer1 = signPlayer1 + signPlayer1 + signPlayer1;
        String winnerPlayer2 = signPlayer2 + signPlayer2 + signPlayer2;

        for (int win = 0; win < 8; win++) {
            String line = null;
            switch (win) {
                case 0:
                    line = boardArray[0][0] + boardArray[0][1] + boardArray[0][2];
                    break;
                case 1:
                    line = boardArray[1][0] + boardArray[1][1] + boardArray[1][2];
                    break;
                case 2:
                    line = boardArray[2][0] + boardArray[2][1] + boardArray[2][2];
                    break;
                case 3:
                    line = boardArray[0][0] + boardArray[1][0] + boardArray[2][0];
                    break;
                case 4:
                    line = boardArray[0][1] + boardArray[1][1] + boardArray[2][1];
                    break;
                case 5:
                    line = boardArray[0][2] + boardArray[1][2] + boardArray[2][2];
                    break;
                case 6:
                    line = boardArray[0][0] + boardArray[1][1] + boardArray[2][2];
                    break;
                case 7:
                    line = boardArray[0][2] + boardArray[1][1] + boardArray[2][0];
                    break;
            }
            if (line.equals(winnerPlayer1)) {
                return signPlayer1;
            } else if (line.equals(winnerPlayer2)){
                return signPlayer2;
            }
        }
        return "";
    }
}



