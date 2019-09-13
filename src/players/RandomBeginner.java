package players;

import java.util.Random;

public class RandomBeginner {
    public static int randomBeginner(Player[] listPlayers ) {
        int rnd = new Random().nextInt(listPlayers.length);
        return rnd;
    }
}
