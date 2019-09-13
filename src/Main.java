import board.Board;
import players.Player;
import players.RandomBeginner;
import java.util.Optional;
import static java.lang.System.exit;

public class Main {

    private static final String PRINT_HEADER = "_ _ _ ____ _    ____ ____ _  _ ____    ___ ____    ___ _ ____ ___ ____ ____ ___ ____ ____ \n" +
            "| | | |___ |    |    |  | |\\/| |___     |  |  |     |  | |     |  |__| |     |  |  | |___ \n" +
            "|_|_| |___ |___ |___ |__| |  | |___     |  |__|     |  | |___  |  |  | |___  |  |__| |___ \n" +
            "                                                                                          ";
    private static final String PRINT_BEGIN = "Let the game begin!";

    private static void printLine() {
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        //Start of the game
        System.out.println(PRINT_HEADER);
        printLine();

        //Ask for names
        Player[] players = Player.callPlayers();
        printLine();

        //Choose random a beginner
        int playerBeginner = RandomBeginner.randomBeginner(players);
        System.out.println("The computer randomly chooses who starts first .....");
        printLine();
        System.out.println("This player starts: " + players[playerBeginner].getUserName());
        printLine();

        //Start of game heder
        System.out.println(PRINT_BEGIN);
        printLine();

        //Board instruction
        Board.printboardInstructions();

        //Create object board
        Board board = new Board();
        System.out.println(board.drawBoard());
        printLine();

        //First player starts
        System.out.println(players[playerBeginner].getUserName() + " let's give it a go! On which number would you like your sign?");

        //Create winner variable for check if there is already a winner
        Optional<String> winner = Optional.empty();

        //Start counter for calculate a draw
        int counter = 0;

        while (!winner.isPresent()) {

            // Counter for counting if there is a draw
            if (counter > 8){
                System.out.println("No winner! It's a draw!");
                exit(0);
            }

            //Let player set a number
            System.out.println(players[playerBeginner].getUserName() + ", enter your number:");

            //Pick a number
            String number = Player.pickNumber();

            //Check if number is legal
            boolean checkNumber = Player.checkNumber(number);
            if (checkNumber){
                System.out.println("This is not a valid number. Try again.");
                continue;
            }

            //Check if it a single number between 1-9
            if (number.length() >= 2 | number.equals("0")){
                System.out.println("This number is not on the board. Try again");
                continue;
            }

            // Parse string to integer
            int num = Integer.parseInt(number);

            //Check if number is already set before
            boolean isNumberSet = board.isNumberSet(num);
            if (isNumberSet){
                System.out.println("This number is already picked before. Please try again.");
                continue;
            }

            //Set sign
            board.setSign(num, players[playerBeginner].getSign());

            //Visual representation
            printLine();
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
        if (winner.get().equalsIgnoreCase("X")) {
            System.out.println(players[1].getUserName() + " is the winner");
        } else if (winner.get().equalsIgnoreCase("O")) {
            System.out.println(players[0].getUserName() + " is the winner");
        }
    }
}
