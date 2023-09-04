import java.util.ArrayList;
import java.util.Collections;

public class PossibleTiles { //all possible tiles used for gameplay

    ArrayList<Tile> possibleTilesArray = new ArrayList<>(75);

    Tile v1 = new Tile(3, 5, new int[] {2, 3}, 0);
    Tile v2 = new Tile(3, 5, new int[] {2, 5}, 0);
    Tile v3 = new Tile(3, 5, new int[] {3, 5}, 0);
    Tile v4 = new Tile(3, 5, new int[] {3, 4}, 0);
    Tile v5 = new Tile(3, 5, new int[] {5, 4}, 0);
    Tile v6 = new Tile(3, 5, new int[] {4, 5, 3}, 0);
    Tile v7 = new Tile(3, 1, new int[] {2, 4}, 0);
    Tile v8 = new Tile(3, 1, new int[] {3, 4}, 0);
    Tile v9 = new Tile(3, 1, new int[] {3, 1}, 0);
    Tile v10 = new Tile(3, 1, new int[] {5, 1}, 0);
    Tile v11 = new Tile(3, 1, new int[] {2, 5}, 0);
    Tile v12 = new Tile(3, 1, new int[] {4, 3, 1}, 0);
    Tile v13 = new Tile(3, 3, new int[] {2}, 0); //2
    Tile v14 = new Tile(3, 3, new int[] {3}, 0);
    Tile v15 = new Tile(3, 3, new int[] {5}, 0); //2
    Tile v16 = new Tile(5, 5, new int[] {5}, 0);
    Tile v17 = new Tile(5, 5, new int[] {4}, 0); //2
    Tile v18 = new Tile(5, 5, new int[] {1}, 0); //2
    Tile v19 = new Tile(5, 1, new int[] {4, 3, 5}, 0);
    Tile v20 = new Tile(5, 1, new int[] {4, 1, 5}, 0);
    Tile v21 = new Tile(5, 1, new int[] {3, 5}, 0);
    Tile v22 = new Tile(5, 1, new int[] {3, 4}, 0);
    Tile v23 = new Tile(5, 1, new int[] {5, 1}, 0);
    Tile v24 = new Tile(5, 1, new int[] {4, 1}, 0);
    Tile v25 = new Tile(1, 1, new int[] {4}, 0); //2
    Tile v26 = new Tile(1, 1, new int[] {5}, 0); //2
    Tile v27 = new Tile(1, 1, new int[] {3}, 0);
    Tile v28 = new Tile(2, 1, new int[] {5, 2, 1}, 0);
    Tile v29 = new Tile(4, 4, new int[] {4}, 0);
    Tile v30 = new Tile(4, 4, new int[] {1}, 0); //2
    Tile v31 = new Tile(4, 4, new int[] {2}, 0); //2
    Tile v32 = new Tile(1, 4, new int[] {4, 2, 1}, 0);
    Tile v33 = new Tile(1, 4, new int[] {5, 4}, 0);
    Tile v34 = new Tile(1, 4, new int[] {5, 1}, 0);
    Tile v35 = new Tile(1, 4, new int[] {4, 1}, 0);
    Tile v36 = new Tile(1, 4, new int[] {4, 2}, 0);
    Tile v37 = new Tile(1, 4, new int[] {1, 2}, 0);
    Tile v38 = new Tile(4, 2, new int[] {4, 1}, 0);
    Tile v39 = new Tile(4, 2, new int[] {4, 2}, 0);
    Tile v40 = new Tile(4, 2, new int[] {1, 2}, 0);
    Tile v41 = new Tile(4, 2, new int[] {1, 3}, 0);
    Tile v42 = new Tile(4, 2, new int[] {2, 3}, 0);
    Tile v43 = new Tile(4, 2, new int[] {4, 2, 1}, 0);
    Tile v44 = new Tile(5, 4, new int[] {5, 2}, 0);
    Tile v45 = new Tile(5, 4, new int[] {5, 1}, 0);
    Tile v46 = new Tile(5, 4, new int[] {3, 1}, 0);
    Tile v47 = new Tile(5, 4, new int[] {5, 2, 1}, 0);
    Tile v48 = new Tile(5, 4, new int[] {4, 2, 5}, 0);
    Tile v49 = new Tile(5, 4, new int[] {3, 4}, 0);
    Tile v50 = new Tile(2, 3, new int[] {1, 3, 2}, 0);
    Tile v51 = new Tile(2, 5, new int[] {3, 4}, 0);
    Tile v52 = new Tile(2, 5, new int[] {5, 3, 2}, 0);
    Tile v53 = new Tile(2, 5, new int[] {4, 3, 5}, 0);
    Tile v54 = new Tile(2, 3, new int[] {1, 3}, 0);
    Tile v55 = new Tile(3, 4, new int[] {1, 3, 5}, 0);
    Tile v56 = new Tile(3, 4, new int[] {5, 4}, 0);
    Tile v57 = new Tile(3, 4, new int[] {3, 1}, 0);
    Tile v58 = new Tile(3, 4, new int[] {3, 2}, 0);
    Tile v59 = new Tile(3, 4, new int[] {5, 2}, 0);
    Tile v60 = new Tile(3, 4, new int[] {2, 4}, 0);
    Tile v61 = new Tile(2, 2, new int[] {1}, 0);
    Tile v62 = new Tile(2, 2, new int[] {2}, 0);
    Tile v63 = new Tile(2, 2, new int[] {3}, 0);
    Tile v64 = new Tile(2, 5, new int[] {1, 3}, 0);
    Tile v65 = new Tile(2, 5, new int[] {1, 5}, 0);
    Tile v66 = new Tile(2, 5, new int[] {2, 4}, 0);
    Tile v67 = new Tile(2, 1, new int[] {1, 4}, 0);
    Tile v68 = new Tile(2, 1, new int[] {2, 4}, 0);
    Tile v69 = new Tile(2, 1, new int[] {3, 5}, 0);
    Tile v70 = new Tile(2, 1, new int[] {3, 1}, 0);
    Tile v71 = new Tile(2, 1, new int[] {4, 3, 2}, 0);
    Tile v72 = new Tile(2, 3, new int[] {1, 2}, 0);
    Tile v73 = new Tile(2, 3, new int[] {3, 5}, 0);
    Tile v74 = new Tile(2, 3, new int[] {5, 3, 2}, 0);
    Tile v75 = new Tile(2, 3, new int[] {2, 5}, 0);

    public ArrayList<Tile> setPossibleTiles () { //sets the random collection of all possible tiles
        Collections.addAll(this.possibleTilesArray, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v13, v14, v15, v15, v16, v17, v17, v18, v18, v19, v20, v21, v22, v23, v24, v25, v25, v26, v26, v27, v28, v29, v30, v30, v31, v31, v32, v33, v34, v35, v36, v37, v38, v39, v40, v41, v42, v43, v44, v45, v46, v47, v48, v49, v50, v51, v52, v53, v54, v55, v56, v57, v58, v59, v60, v61, v62, v63, v64, v65, v66, v67, v68, v69, v70, v71, v72, v73, v74, v75);
        Collections.shuffle(this.possibleTilesArray);
        return this.possibleTilesArray;
    }

}
