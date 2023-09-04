import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Board {

    public ArrayList<Pair> pairs;
    public ArrayList<Tile> tiles;
    public ArrayList<WildlifeToken> wildlifeTokens;

    public Board() {
        this.tiles = new ArrayList<Tile>();
        this.wildlifeTokens = new ArrayList<WildlifeToken>();
        this.pairs = new ArrayList<Pair>();
    }
    //draws the actual board and displays it in terminal
    public void drawBoard() {
        //find maximum Q and R
        int maxQ = this.getFurthestX();
        int maxR = this.getFurthestY();

        /* the following loop works by checking the horizontal and vertical lengths of the board
         * by querying the furthest coordinates on each edge. this determines
         * how large to draw the board. once the width and height of the board is determined, the loop
         * concatenates strings from the string representation of tiles and prints them to form a
         * nice map for the user */

        System.out.println("Board:");
        Tile t;
        boolean offset = false;
        int y = maxR * -1;
        while (y <= maxR) {
            offset = y % 2 != 0;

            int i = 0;
            while (i < 4) {
                StringBuilder line;
                if (offset) {
                    line = new StringBuilder("    ");
                } else {
                    line = new StringBuilder();
                }
                int x = maxQ * -1;
                while (x <= maxQ) {
                    t = this.getTileByCoordinates(x, y);

                    if (t != null) {
                        String s = t.getStringRep().get(i);
                        s = s.replace("\n", "").replace("\r", "");
                        line.append(s);
                    } else {
                        line.append("         ");
                    }
                    x++;
                }
                System.out.print(line.toString() + '\n');
                i++;
            }
            y++;
        }

    }
    //checks if the user should be able to place a tile in a given place. it makes sure the tile is next to an existing tile.
    //it also checks the y level of the tile to make sure the coordinates are correctly adjusted. same method is later used in the scoring.
    public boolean isTilePlacementPossible( int x, int y) {
        /* Tile is already taken */
        if (this.getTileByCoordinates(x, y) != null) return false;

        if ((y & 1) == 0) {
            ArrayList<ArrayList<Integer>> coords1 = new ArrayList<>();
            coords1.add(new ArrayList<>(Arrays.asList(x - 1, y - 1)));
            coords1.add(new ArrayList<>(Arrays.asList(x, y - 1)));
            coords1.add(new ArrayList<>(Arrays.asList(x+ 1, y)));
            coords1.add(new ArrayList<>(Arrays.asList(x, y + 1)));
            coords1.add(new ArrayList<>(Arrays.asList(x - 1, y + 1)));
            coords1.add(new ArrayList<>(Arrays.asList(x - 1, y)));

            for (ArrayList<Integer> c : coords1) {
                if (this.getTileByCoordinates(c.get(0), c.get(1)) != null) return true;
            }
        } else {
            ArrayList<ArrayList<Integer>> coords2 = new ArrayList<>();
            coords2.add(new ArrayList<>(Arrays.asList(x + 1, y - 1)));
            coords2.add(new ArrayList<>(Arrays.asList(x + 1, y)));
            coords2.add(new ArrayList<>(Arrays.asList(x + 1, y + 1)));
            coords2.add(new ArrayList<>(Arrays.asList(x, y + 1)));
            coords2.add(new ArrayList<>(Arrays.asList(x - 1, y)));
            coords2.add(new ArrayList<>(Arrays.asList(x, y - 1)));

            for (ArrayList<Integer> c : coords2) {
                if (this.getTileByCoordinates(c.get(0), c.get(1)) != null) return true;
            }
        }
        return false;
    }
    //checks if a wildlife token already has coordinates
    public boolean isTokenOccupied(int x, int y) {
        for (WildlifeToken w : this.wildlifeTokens) {
            if (w.getX() == null || w.getY() == null) {
                continue;
            }
            if (w.getX() == x && w.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public int getFurthestX() {
        if (this.tiles.isEmpty()) return 0;

        int max = 0;
        int x;
        for (Tile t : this.tiles) {
            x = t.getX();

            /* Check X value */
            if (x < 0) { x *= -1; }
            if (x > max) { max = x + 1; }
        }

        return max;
    }
    public int getFurthestY() {
        if (this.tiles.isEmpty()) return 0;

        int max = 0;
        int y;
        for (Tile t : this.tiles) {
            y = t.getY();

            /* Check X value */
            if (y < 0) { y *= -1; }
            if (y > max) { max = y + 1; }
        }

        return max;

    }
    //gets a tile from a board using its coordinates by looping through all the tiles in the board and checking for matches with given coordinates.
    public Tile getTileByCoordinates(int x, int y) {
        for (Tile t : this.tiles) {
            if (t.getX() == null && t.getY() == null) {
                return null;
            } else if (t.getX() == x && t.getY() == y) {
                return t;
            }
        }
        return null;
    }


}