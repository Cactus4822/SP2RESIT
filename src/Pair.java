public class Pair {
    WildlifeToken wildlifeToken;
    Tile tile;
    //class to make pairs of tiles and wildlife to printout during gameplay
    public Pair(WildlifeToken w, Tile t) {
        this.wildlifeToken = w;
        this.tile = t;
    }
    //simple stringRep showing tile and corresponding wildlife token.
    public String getStringRep() {
        String s = "";
        if (tile != null) {
            s += tile.getStringRep().get(0) + "    " + wildlifeToken.getAnimalLetter() + "\n";
            s += tile.getStringRep().get(1) + "\n";
            s += tile.getStringRep().get(2) + "\n";
            s += tile.getStringRep().get(3) + "\n";
        }

        return s;
    }

    public void printPair() {
        System.out.println(getStringRep());
    }
    public WildlifeToken getWildlifeToken() {
        return this.wildlifeToken;
    }
    public Tile getTile() {
        return this.tile;
    }

}
