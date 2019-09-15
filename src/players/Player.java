package players;

import java.util.Random;
import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in); 

    private String userName;
    private String sign;

    public String getUserName() {
        return userName;
    }

    public String getSign() {
        return sign;
    }

    //This method will call the players and ask for their names 
    public Player[] callPlayers() {

        //Creating player objects and set the sign per player
        Player player1 = new Player();
        player1.sign = "O";
        Player player2 = new Player();
        player2.sign = "X";

        //Ask for player name and reads input and will put this is the objects variable username
        System.out.println("Please enter username of player 1:");                   
        player1.userName = scanner.nextLine();                                      
        System.out.println("Username of player 1 is: " + player1.userName);

        //Ask for player name and reads input and will put this is the objects variable username
        System.out.println("Please enter username of player 2:");                   
        player2.userName = scanner.nextLine();                                     
        System.out.println("Username of player 2 is: " + player2.userName);

        //Initialises an array of the 2 player objects and return this list
        Player[] listPlayers = {player1, player2};
        return listPlayers;
    }

    //This method will picks random the player who may start 
    public int randomBeginner(Player[] listPlayers ) {
        int rnd = new Random().nextInt(listPlayers.length);
        return rnd;
    }
}
