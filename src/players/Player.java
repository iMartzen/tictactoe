package players;

import java.util.Random;

public class Player {

    private String userName;
    private String sign;

    public Player(){}
    
    public Player(String userName, String sign){
        this.userName = userName;
        this.sign = sign;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getSign(){
        return sign;
    }

    public void setSign(String sign){
        this.sign = sign;
    }

    //This method will picks random the player who may start 
    public int randomBeginner(Player[] listPlayers ) {
        int rnd = new Random().nextInt(listPlayers.length);
        return rnd;
    }
}
