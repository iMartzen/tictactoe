package players;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {

    private String userName;
    private String sign;

    public String getUserName() {
        return userName;
    }

    public String getSign() {
        return sign;
    }

    public static Player[] callPlayers() {

        Player player1 = new Player();                                              //Creates player1
        player1.sign = "O";                                                         //Player1 gets sign O
        Player player2 = new Player();                                              //Creates player2
        player2.sign = "X";                                                         //Player2 gets sign X

        Scanner scanner = new Scanner(System.in);                                   //Creates a scanner

        System.out.println("Please enter username of player 1:");                   //Ask for name
        player1.userName = scanner.nextLine();                                      //Reads input
        System.out.println("Username of player 1 is: " + player1.userName);

        System.out.println("Please enter username of player 2:");                   //Asks for name
        player2.userName = scanner.nextLine();                                      //Reads input
        System.out.println("Username of player 2 is: " + player2.userName);

        Player[] listPlayers = {player1, player2};                                  //Initialize an array
        return listPlayers;                                                         //Returns the list of players.
    }

    //This function will let the player pick a number
    public static String pickNumber(){
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        System.out.println("You've picked number: "+num);
        return num;
}

    //This function will check if number is between 0-9
    public static boolean checkNumber(String num) {
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(num);
        return matcher.find();
    }
}
