import java.util.ArrayList;
import java.util.Collections;

public class PossibleTokens {

    //all possible tokens
    ArrayList<WildlifeToken> possibleTokens = new ArrayList<>(100);

    public ArrayList<WildlifeToken> setPossibleTokens () { // all possible tokens, there are twenty of each hence the for statements
        WildlifeToken w1 = new WildlifeToken("Bear");
        WildlifeToken w2 = new WildlifeToken("Fox");
        WildlifeToken w3 = new WildlifeToken("Salmon");
        WildlifeToken w4 = new WildlifeToken("Elk");
        WildlifeToken w5 = new WildlifeToken("Hawk");
        for (int i = 0; i < 20; i++) {
            possibleTokens.add(w1);
        }
        for (int i = 20; i < 40; i++) {
            possibleTokens.add(w2);
        }
        for (int i = 40; i < 60; i++) {
            possibleTokens.add(w3);
        }
        for (int i = 60; i < 80; i++) {
            possibleTokens.add(w4);
        }
        for (int i = 80; i < 100; i++) {
            possibleTokens.add(w5);
        }
        Collections.shuffle(possibleTokens);
        return possibleTokens;
    }

}
