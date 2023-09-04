import java.util.ArrayList;
import java.util.Collections;

public class starterTile { //sets out the possible starterTiles

    ArrayList<ArrayList<Tile>> starterTiles = new ArrayList<>(5); // array list of starter tiles

    ArrayList<Tile> start1; //array list of tiles in the first starter tile
    ArrayList<Tile> start2;
    ArrayList<Tile> start3;
    ArrayList<Tile> start4;
    ArrayList<Tile> start5;

    Tile s1t1 = new Tile(1, 1, new int[] {1}, 0);
    Tile s1t2 = new Tile(4, 3, new int[] {4, 3, 1}, 3);
    Tile s1t3 = new Tile(5, 2, new int[] {2, 5}, 1);
    Tile s2t1 = new Tile(2, 2, new int[] {2},  0);
    Tile s2t2 = new Tile(3, 1, new int[] {1, 3, 5},  3);
    Tile s2t3 = new Tile(4, 5, new int[] {4, 2},  1);
    Tile s3t1 = new Tile(3, 3, new int[] {3},  0);
    Tile s3t2 = new Tile(2, 4, new int[] {1, 3, 2},  3);
    Tile s3t3 = new Tile(1, 5, new int[] {5, 4},  1);
    Tile s4t1 = new Tile(4, 4, new int[] {4},  0);
    Tile s4t2 = new Tile(5, 3, new int[] {4, 3, 2},  3);
    Tile s4t3 = new Tile(2, 1, new int[] {5, 1},  1);
    Tile s5t1 = new Tile(5, 5, new int[] {5},  0);
    Tile s5t2 = new Tile(1, 4, new int[] {4, 1, 5},  3);
    Tile s5t3 = new Tile(3, 2, new int[] {2, 3},  1);

    public starterTile() {
        start1 = new ArrayList<>(3); //array list of tiles in the first starter tile
        Collections.addAll(start1, s1t1, s1t2, s1t3);

        start2 = new ArrayList<>(3);
        Collections.addAll(start2, s2t1, s2t2, s2t3);

        start3 = new ArrayList<>(3);
        Collections.addAll(start3, s3t1, s3t2, s3t3);

        start4 = new ArrayList<>(3);
        Collections.addAll(start4, s4t1, s4t2, s4t3);

        start5 = new ArrayList<>(3);
        Collections.addAll(start5, s5t1, s5t2, s5t3);

        Collections.addAll(starterTiles, start1, start2, start3, start4, start5);


    }



}
