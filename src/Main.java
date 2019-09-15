import board.*;
import players.*;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {

    private static final String PRINT_HEADER = "_ _ _ ____ _    ____ ____ _  _ ____    ___ ____    ___ _ ____ ___ ____ ____ ___ ____ ____ \n" +
            "| | | |___ |    |    |  | |\\/| |___     |  |  |     |  | |     |  |__| |     |  |  | |___ \n" +
            "|_|_| |___ |___ |___ |__| |  | |___     |  |__|     |  | |___  |  |  | |___  |  |__| |___ \n" +
            "                                                                                          ";

    public static final Scanner scanner = new Scanner(System.in);  
    
    public static void main(String[] args) {
        
        //Start of the game
        System.out.println(PRINT_HEADER);
        
        // Create object player1         
        System.out.println("Please enter username of player 1:");   
        String usernamePlayer1 = scanner.nextLine();
        System.out.println("What sign would you like to play with?");
        String signPlayer1 = scanner.nextLine();
        Player player1 = new Player(usernamePlayer1, signPlayer1);
        System.out.println("Username of player 1 is: " + player1.getUserName() + " and will play with this sign: " + player1.getSign()); 

        //Create object player2
        System.out.println("Please enter username of player 2:");
        String usernamePlayer2 = scanner.nextLine();
        System.out.println("What sign would you like to play with?");
        String signPlayer2 = scanner.nextLine();
        Player player2 = new Player(usernamePlayer2, signPlayer2);
        System.out.println("Username of player 2 is: " + player2.getUserName()+ " and will play with this sign: " + player2.getSign());

        //Choose random a beginner
        Player player = new Player(); // RAY: Waarom hier een nieuwe player?
        Player[] players = {player1, player2};
        //int playerBeginner = player.randomBeginner(players); //RAY: Om hier de randomPlayer methode te kunnen gebruiken? 🙄
        
        // RAY: Genereer een getal tussen 1 en 2, waarbij 1 gelijk is aan player1 en 2 gelijk is aan player2
        int playerBeginner = new Random().nextInt(2) + 1; //(zie https://www.mkyong.com/java/java-generate-random-integers-in-a-range/)
        
        System.out.println("--------------------------------");
        System.out.println("The computer randomly chooses who starts first. This player starts: " + players[playerBeginner].getUserName());
        
        //Creates object board
        Board board = new Board();

        //Draw the board, dit gebeurt direct na het initialiseren van een new board, en zou ook door de constructor gedaan kunnen worden.
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
            // ik zou hier (voor nu) een static methode van de main class gebruiken om het "vakje" op te vragen waar de speler zijn sign wil plaatsen, 
            // je kan dus de scanner die hier boven gebruikt is opnieuw gebruiken. In diezelfde methode controlleer je of het vakje geldig is, dus
            // tussen 1 en 9, maar wat nu als een vakje al gevuld is? ... moet je zelf ff over na denken ;-) .. 
            // hint: wie weet de status van het speel board?
            int num = board.pickNumber();
        
            //Check if it a single number between 1-9
            // deze kan dan verhuizen naar bovengenoemde methode, maar dan een beetje anders? ... misschien continue eruit laten 
            // en de if conditie anders opstellen? 
            if (num <= 0 || num > 9){
                System.out.println("This number is not on the board. Try again");
                continue;
            }
            
            //Check if number is already set before
            // Hey! misschien heb je hier al iets wat we zochten?
            // misschien een beetje anders?  ... misschien continue eruit laten 
            // en de if conditie anders opstellen? 
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
//             if (playerBeginner == 0) {
//                 playerBeginner = 1;
//             } else {
//                 playerBeginner = 0;
//             }
            //RAY: bovenstaande kan korter, gebruik de ternary operator (zie https://www.baeldung.com/java-ternary-operator)
            // De variabele playerBeginner, is een beetje vreemd gekozen, omdat playerBeginner niet meer de begin speler is,
            // playerId is misschien nicer???
            playerBeginner = playerBeginner == 0 ? 1 : 0;
            
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
        
        // wat betreft de variabele winner, dat is nu een string die "", "X" of "O" of eigen gekozen signs kan zijn. 
        // Bij "" is er blijkbaar geen winner, bij "X" of "O" is resp. een van beide de winner.
        // wat nu als je in de Board class een boolean field maakt die bijhoudt of er een winner is, 
        // of te wel false = geen winner en true er is een winner. 
        // Een tweede field van (nu nog) type String, die get winnende sign bewaart bijv winnerSign.
        // Voor beide een getter om de stand op te vragen, resp. isWinner() en getWinnerSign()
        // Als je door het aantal pogingen (9) heeb bent en isWinner() is nog steeds false dan is het dus gelijkspel.
        // Is isWinner true, dan getWinnerSign() om op te vragen welk teken het winnende teken is.
        
        // Bovenstaande is nog mooier in de player class bij te houden of de player winner is of niet,   
        // ik vind dat typisch horen bij een player en niet zo zeer bij het board.
        // Voordeel is dat wanneer een player winner is (en dus true) dat je ook het sign meteen hebt, 
        // immers de player class bevat de eigenschap sign.
        
        //Goodbye message
        System.out.println("Thanks for playing TicTacToe! Hope to see you again!");
    }
}
