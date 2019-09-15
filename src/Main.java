import board.*;
import players.*;
import java.util.*;
import static java.lang.System.exit;

public class Main {

    private static final String PRINT_STARTGAME = "_ _ _ ____ _    ____ ____ _  _ ____    ___ ____    ___ _ ____ ___ ____ ____ ___ ____ ____ \\n" +
            "| | | |___ |    |    |  | |\\\\/| |___     |  |  |     |  | |     |  |__| |     |  |  | |___ \\n" +
            "|_|_| |___ |___ |___ |__| |  | |___     |  |__|     |  | |___  |  |  | |___  |  |__| |___ \\n" +
            "                                                                                          ";
    public static void main(String[] args) {
        
        //Start of the game
        System.out.println(PRINT_STARTGAME);
        
        // Create object players 
        Player player = new Player();
        //Ask for names
        Player[] players = player.callPlayers();
        
        //Choose random a beginner
        int playerBeginner = player.randomBeginner(players);
        System.out.println("The computer randomly chooses who starts first. This player starts: " + players[playerBeginner].getUserName());
        
        //Creates object board
        Board board = new Board();

        //Draw the board 
        System.out.println(board.drawBoard());
        
        //First player starts
        System.out.println(players[playerBeginner].getUserName() + " let's give it a go! On which number would you like your sign?");
        
        //Create winner variable for check if there is already a winner
        String winner = "";
        
        //Start counter for calculate a draw
        int counter = 0;

        while (winner.equals("")) {
        
            // Counter for counting if there is a draw
            if (counter > 8){
                System.out.println("No winner! It's a draw!");
                exit(0);
            }
        
            //Let player set a number
            System.out.println(players[playerBeginner].getUserName() + ", enter your number:");
        
            //Pick a number
            int num = board.pickNumber();
        
            //Check if it a single number between 1-9
            if (num <= 0 || num > 9){
                System.out.println("This number is not on the board. Try again");
                continue;
            }
        
            //Check if number is already set before
            boolean isNumberSet = board.isNumberSet(num);
            if (isNumberSet){
                System.out.println("This number is already picked before. Please try again.");
                continue;
            }
        
            //Set sign
            board.setSign(num, players[playerBeginner].getSign());
        
            //Visual representation
            System.out.println(board.drawBoard());
        
            //Change player
            if (playerBeginner == 0) {
                playerBeginner = 1;
            } else {
                playerBeginner = 0;
            }
        
            //Check if there is a winner
            winner = board.getWinner();
        
            //Counter
            counter++;
        }
        
        //Combine winner with name of the player.
        if (winner.equals("X")) {
            System.out.println(players[1].getUserName() + "is the winner. Congratulations!");
        } else if (winner.equalsIgnoreCase("O")) {
            System.out.println(players[0].getUserName() + "is the winner. Congratulations!");
        }
        
        //Goodbye message
        System.out.println("Thanks for playing TicTacToe! Hope to see you again!");
    }
}