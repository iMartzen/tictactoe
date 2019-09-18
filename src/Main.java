import board.*;
import players.*;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static final String PRINT_HEADER = "_ _ _ ____ _    ____ ____ _  _ ____    ___ ____    ___ _ ____ ___ ____ ____ ___ ____ ____ \n" +
            "| | | |___ |    |    |  | |\\/| |___     |  |  |     |  | |     |  |__| |     |  |  | |___ \n" +
            "|_|_| |___ |___ |___ |__| |  | |___     |  |__|     |  | |___  |  |  | |___  |  |__| |___ \n" +
            "                                                                                          ";

    public static final Scanner scanner = new Scanner(System.in);  
    
    public static void main(String[] args) {
        
        //Start of the game
        System.out.println(PRINT_HEADER);
        
        // Create object player1         
        System.out.println(ANSI_GREEN + "Please enter username of player 1:" + ANSI_RESET);   
        String usernamePlayer1 = scanner.nextLine();
        System.out.println(ANSI_GREEN + "What sign would you like to play with?" + ANSI_RESET);
        String signPlayer1 = scanner.nextLine();
        Player player1 = new Player(usernamePlayer1, signPlayer1);
        System.out.println(ANSI_GREEN + "Username of player 1 is: " + player1.getUserName() + " and will play with this sign: " + player1.getSign() + ANSI_RESET); 

        //Create object player2
        System.out.println(ANSI_GREEN + "Please enter username of player 2:" + ANSI_RESET);
        String usernamePlayer2 = scanner.nextLine();
        System.out.println(ANSI_GREEN + "What sign would you like to play with?" + ANSI_RESET);
        String signPlayer2 = scanner.nextLine();
        Player player2 = new Player(usernamePlayer2, signPlayer2);
        System.out.println(ANSI_GREEN + "Username of player 2 is: " + player2.getUserName()+ " and will play with this sign: " + player2.getSign() + ANSI_RESET);

        //Choose random a beginner
        Player[] players = {player1, player2};
        int playerBeginner = player1.randomBeginner(players);
        System.out.println("--------------------------------");
        System.out.println(ANSI_GREEN + "The computer randomly chooses who starts first. This player starts: " + players[playerBeginner].getUserName() + ANSI_RESET);
        
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
            int num = pickNumber();
        
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
            winner = board.getWinner(player1.getSign(), player2.getSign());
        
            //Counter
            counter++;
        }
        
        //Combine winner with name of the player.
        if (winner.equals(signPlayer1)) {
            System.out.println(players[0].getUserName() + "is the winner. Congratulations!");
        } else if (winner.equalsIgnoreCase(signPlayer2)) {
            System.out.println(players[1].getUserName() + "is the winner. Congratulations!");
        }
        
        //Goodbye message
        System.out.println("Thanks for playing TicTacToe! Hope to see you again!");
        System.out.println("");
        System.out.println("");
    }

    //This method will let the player pick a number
    static private int pickNumber(){
        int num = checkNumber();
        System.out.println("You've picked number: " + num);
        return num;
    }

    //This method will check if it is an integer, otherwise it will throw an error.
    static private int checkNumber(){
        while(true){
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                scanner.next();
                System.out.println("That's not " + "an integer. Try again:");
            }
        }
    }
}