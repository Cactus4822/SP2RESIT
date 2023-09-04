import java.util.ArrayList;
import java.util.Arrays;

public class Tile {
    private int arrangement; // the way the terrains are set out on the tile
    private int[] wildlife;
    private final int terrain2;
    private final int terrain1;
    private int keystone;
    ArrayList<Integer> coordinates;
    private ArrayList<String> stringRep;
    private WildlifeToken wt;

    String[] ter = new String[]{HabitatColour.WHITE.getColour(), HabitatColour.WETLAND.getColour(), HabitatColour.MOUNTAIN.getColour(), HabitatColour.FOREST.getColour(), HabitatColour.RIVER.getColour(), HabitatColour.PRAIRIE.getColour()};
    String[] wildlifeColour = new String[]{HabitatColour.WHITE.getColour(), HabitatColour.HAWK.getColour(), HabitatColour.BEAR.getColour(), HabitatColour.ELK.getColour(), HabitatColour.SALMON.getColour(), HabitatColour.FOX.getColour()};
    String[] wildlifeColourBG = new String[]{HabitatColour.WHITE_TEXT.getColour(), HabitatColour.HAWK_BG.getColour(), HabitatColour.BEAR_BG.getColour(), HabitatColour.ELK_BG.getColour(), HabitatColour.SALMON_BG.getColour(), HabitatColour.FOX_BG.getColour()};
    String[] blankResetKey = new String[] {HabitatColour.BLANK.getColour(), HabitatColour.RESET.getColour(), HabitatColour.KEY.getColour()};
    String[] wildlifeChar = new String[] {" ", "H", "B", "E", "S", "F"};
    String[] key = new String[] {" ", "K"};

    public Tile (int terrain1, int terrain2, int[] wildlife, int arrangement) {
        //amount of wildlife to be displayed on the tile
        this.terrain1 = terrain1;
        this.terrain2 = terrain2;
        this.wildlife = wildlife;
        this.arrangement = arrangement;
        int keystone;

        setKeystone();
        setWildlifeLength();

        this.wt = null;
        this.coordinates = new ArrayList<Integer>(2);
        this.coordinates.add(null);
        this.coordinates.add(null);
        stringRep = new ArrayList<String>(4);
        stringRep.add("....");
        stringRep.add("....");
        stringRep.add("....");
        stringRep.add("....");

        }

    public void setCoordinates(int x, int y) {
        this.coordinates.set(0, Integer.valueOf(x));
        this.coordinates.set(1, Integer.valueOf(y));
    }

    public void generateStringRep() {
        for (String s : stringRep) {
            System.out.println(s);
        }
    }

    public int[] getWildlife () {
        return this.wildlife;
    }

    public String getWildlifeChar (int x) {
        return this.wildlifeChar[this.getWildlife()[x]];
    }
    public Integer getX() {
        return this.coordinates.get(0);
    }
    public Integer getY() {
        return this.coordinates.get(1);
    }
    public ArrayList<String> getStringRep() {
    return this.stringRep;
    }

    //rearranging of wildlife length
    public void setWildlifeLength() {
        if (this.wildlife.length == 2) {
            int[] newWildlife = Arrays.copyOf(this.wildlife, wildlife.length + 1);
            int newElement = 0;
            newWildlife[2] = newElement;
            this.wildlife = newWildlife;
        } else if (this.wildlife.length == 1) {
            int[] newWildlife = Arrays.copyOf(this.wildlife, wildlife.length + 2);
            int newElement = 0;
            newWildlife[1] = newElement;
            newWildlife[2] = newElement;
            this.wildlife = newWildlife;
        }
    }

    //set keystone
    public void setKeystone() {
        if (terrain1 == terrain2) {
            keystone = 1;
        } else {
            keystone = 0;
        }
    }

    public int getKeystone () {
        return this.keystone;
    }

    public void setStringRep() {

        //different possible arrangements for the tile
        switch (arrangement) {
            // 1 1 1 1
            // 1     2
            // 1     2
            // 2 2 2 2
            case 0 -> {
                stringRep.set(3, ter[terrain1] + "         " + blankResetKey[1]);
                stringRep.set(2, ter[terrain1] + "  " + blankResetKey[1] + ter[0] + " " + wildlifeColour[wildlife[0]] + wildlifeChar[wildlife[0]] + " " + ter[0] + wildlifeColour[wildlife[1]] + wildlifeChar[wildlife[1]] + blankResetKey[1] + ter[0] + " " + ter[terrain2] + "  " + blankResetKey[1]);
                stringRep.set(1, ter[terrain1] + "  " + blankResetKey[1] + ter[0] + " " + wildlifeColour[wildlife[2]] + wildlifeChar[wildlife[2]] + " " + ter[0] + blankResetKey[2] + key[keystone] + blankResetKey[1] + ter[0] + " " + ter[terrain2] + "  " + blankResetKey[1]);
                stringRep.set(0, ter[terrain2] + "         " + blankResetKey[1]);
            }
            // 2 2 2 2
            // 2     1
            // 2     1
            // 1 1 1 1
            case 1 -> {
                stringRep.set(3, ter[terrain2] + "         " + blankResetKey[1]);
                stringRep.set(2, ter[terrain2] + "  " + blankResetKey[1] + ter[0] + " " + wildlifeColour[wildlife[0]] + wildlifeChar[wildlife[0]] + " " + ter[0] + wildlifeColour[wildlife[1]] + wildlifeChar[wildlife[1]] + blankResetKey[1] + ter[0] + " " + ter[terrain1] + "  " + blankResetKey[1]);
                stringRep.set(1, ter[terrain2] + "  " + blankResetKey[1] + ter[0] + " " + wildlifeColour[wildlife[2]] + wildlifeChar[wildlife[2]] + " " + ter[0] + blankResetKey[2] + key[keystone] + blankResetKey[1] + ter[0] + " " + ter[terrain1] + "  " + blankResetKey[1]);
                stringRep.set(0, ter[terrain1] + "         " + blankResetKey[1]);
            }
            // 1 1 1 1
            // 2     1
            // 2     1
            // 2 2 2 2
            case 2 -> {
                stringRep.set(3, ter[terrain1] + "        " + blankResetKey[1]);
                stringRep.set(2, ter[terrain2] + "  " + blankResetKey[1] + ter[0] + " " + wildlifeColour[wildlife[0]] + wildlifeChar[wildlife[0]] + " " + ter[0] + wildlifeColour[wildlife[1]] + wildlifeChar[wildlife[1]] + blankResetKey[1] + ter[0] + " " + ter[terrain1] + "  " + blankResetKey[1]);
                stringRep.set(1, ter[terrain2] + "  " + blankResetKey[1] + ter[0] + " " + wildlifeColour[wildlife[2]] + wildlifeChar[wildlife[2]] + " " + ter[0] + blankResetKey[2] + key[keystone] + blankResetKey[1] + ter[0] + " " + ter[terrain1] + "  " + blankResetKey[1]);
                stringRep.set(0, ter[terrain2] + "         " + blankResetKey[1]);
            }
            // 2 2 2 2
            // 1     2
            // 1     2
            // 1 1 1 1
            case 3 -> {
                stringRep.set(3, ter[terrain2] + "         " + blankResetKey[1]);
                stringRep.set(2, ter[terrain1] + "  " + blankResetKey[1] + ter[0] + " " + wildlifeColour[wildlife[0]] + wildlifeChar[wildlife[0]] + " " + ter[0] + wildlifeColour[wildlife[1]] + wildlifeChar[wildlife[1]] + blankResetKey[1] + ter[0] + " " + ter[terrain2] + "  " + blankResetKey[1]);
                stringRep.set(1, ter[terrain1] + "  " + blankResetKey[1] + ter[0] + " " + wildlifeColour[wildlife[2]] + wildlifeChar[wildlife[2]] + " " + ter[0] + blankResetKey[2] + key[keystone] + blankResetKey[1] + ter[0] + " " + ter[terrain2] + "  " + blankResetKey[1]);
                stringRep.set(0, ter[terrain1] + "         " + blankResetKey[1]);
            }
        }
    }

    //sets the wildlife token into the tile
    public void setWildlifeToken(WildlifeToken token) {
        if (this.wt != null) {
            System.out.println("This tile already has a wildlife token");
        } else {
            String s = token.getAnimalLetter();
            if (this.stringRep.get(1).contains(s) || this.stringRep.get(2).contains(s)) {
                this.wt = token;
                updateStringRep();
            } else {
                System.out.println("This tile does not support that wildlife token");
            }
        }
    }

    public boolean hasWildLifeToken () {
        return wt != null;
    }

    // fired off after a wildlife token is added
    private void updateStringRep() {
        String bgColor = switch (this.wt.getAnimalLetter()) {
            case "H" -> wildlifeColourBG[1]; // Blue
            case "B" -> wildlifeColourBG[2]; // Brown
            case "S" -> wildlifeColourBG[4]; // Pink
            case "F" -> wildlifeColourBG[5]; // Orange
            case "E" -> wildlifeColourBG[3]; // Black
            default -> throw new RuntimeException("Invalid Wildlife token type");
        };

        //different possible arrangements for the tile
        switch (arrangement) {
            case 0, 3 -> {
                stringRep.set(2, ter[terrain1] + "  " + blankResetKey[1] + bgColor + " " + wildlifeColourBG[0] + this.wt.getAnimalLetter() + "   " + ter[terrain2] + "  " + blankResetKey[1]);
                stringRep.set(1, ter[terrain1] + "  " + blankResetKey[1] + bgColor + "   " + wildlifeColourBG[0] + key[keystone] + " " + ter[terrain2] + "  " + blankResetKey[1]);
            }
            case 1, 2 -> {
                stringRep.set(2, ter[terrain2] + "  " + blankResetKey[1] + bgColor + " " + wildlifeColourBG[0] + this.wt.getAnimalLetter() + "   " + ter[terrain1] + "  " + blankResetKey[1]);
                stringRep.set(1, ter[terrain2] + "  " + blankResetKey[1] + bgColor + "   " + wildlifeColourBG[0] + key[keystone] + " " + ter[terrain1] + "  " + blankResetKey[1]);
            }
        }
    }


    public WildlifeToken getWt() {
        return wt;
    }
}