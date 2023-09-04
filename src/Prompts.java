import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prompts {


    Scanner confirmationIn = new Scanner(System.in);

    public String[] namePlayersPrompt() {
        Scanner nameIn = new Scanner(System.in);
        String[] playerNames = new String[2];

        //prompts the user to input the player names
        for (int i = 0; i < 2; i++) {
            System.out.print("Please enter the name of Player " + (i + 1) + ": ");
            playerNames[i] = nameIn.nextLine().trim();
            if (playerNames[i].isEmpty()) {
                System.out.println("Error. Player name cannot be empty. Try again.");
                i--;
                continue;
            } else if (playerNames[i].equalsIgnoreCase("quit")) Main.exit();
            for (int j = 0; j < i; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    System.out.println("Error. Two players cannot have the same name. Try again.");
                    i--;
                    break;
                }
            }
        }

        //confirmation prompt on the names of the players they have inputted. Returns to start of method if input is 'n'
        System.out.print("\nThe names of the players are: " + Arrays.toString(playerNames) + ". Is this correct? (y/n): ");
        while (true) {
            String confirmation = confirmationIn.nextLine();
            if (confirmation.equalsIgnoreCase("y")) {
                System.out.println("");
                return playerNames;
            } else if (confirmation.equalsIgnoreCase("n")) {
                System.out.println("");
                break;
            } else if (confirmation.equalsIgnoreCase("quit")) Main.exit();
            else if (confirmation.isBlank()) {
                System.out.print("Error. Please enter 'y' to confirm or 'n' to try again: ");
            } else System.out.print("Error. Please enter 'y' to confirm or 'n' to try again: ");
        }
        return namePlayersPrompt();
    }

    //prompts the user to choose a wildlife token, tile pair, also deals with culling.
    public Pair pairPrompt(ArrayList<Tile> possibleT, ArrayList<WildlifeToken> possibleW, Board b) {

        System.out.println("Please choose a Tile/Wildlife Token combo between 1 and 4: \n");

        possibleT.get(0).setStringRep();
        possibleT.get(1).setStringRep();
        possibleT.get(2).setStringRep();
        possibleT.get(3).setStringRep();

        Pair p1 = new Pair(possibleW.get(0), possibleT.get(0));
        Pair p2 = new Pair(possibleW.get(1), possibleT.get(1));
        Pair p3 = new Pair(possibleW.get(2), possibleT.get(2));
        Pair p4 = new Pair(possibleW.get(3), possibleT.get(3));

        p1.printPair();
        p2.printPair();
        p3.printPair();
        p4.printPair();

        //automatic culling of 4 of the same tokens
        while (p1.getWildlifeToken() == p2.getWildlifeToken() && p2.getWildlifeToken() == p3.getWildlifeToken() && p3.getWildlifeToken() == p4.getWildlifeToken()) {

            possibleW.remove(p1.getWildlifeToken());
            possibleW.remove(p2.getWildlifeToken());
            possibleW.remove(p3.getWildlifeToken());
            possibleW.remove(p4.getWildlifeToken());

            p1 = new Pair(possibleW.get(0), possibleT.get(0));
            p2 = new Pair(possibleW.get(1), possibleT.get(1));
            p3 = new Pair(possibleW.get(2), possibleT.get(2));
            p4 = new Pair(possibleW.get(3), possibleT.get(3));

            p1.printPair();
            p2.printPair();
            p3.printPair();
            p4.printPair();
        }

        //a bunch of if statements to allow the player to cull if they are presented with 3 identical tokens
        if (p1.getWildlifeToken() == p2.getWildlifeToken() && p2.getWildlifeToken() == p3.getWildlifeToken()) {
            System.out.println("There are 3 Wildlife Tokens of the same kind, Would you like to cull them? (y/n)");
            Scanner yn = new Scanner(System.in);
            while (true) {
                String confirmation = yn.nextLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    System.out.println("");
                    possibleW.remove(p1.getWildlifeToken());
                    possibleW.remove(p2.getWildlifeToken());
                    possibleW.remove(p3.getWildlifeToken());

                    p1 = new Pair(possibleW.get(0), possibleT.get(0));
                    p2 = new Pair(possibleW.get(1), possibleT.get(1));
                    p3 = new Pair(possibleW.get(2), possibleT.get(2));

                    p1.printPair();
                    p2.printPair();
                    p3.printPair();
                    p4.printPair();

                    break;

                } else if (confirmation.equalsIgnoreCase("n")) {
                    System.out.println("");
                    p1.printPair();
                    p2.printPair();
                    p3.printPair();
                    p4.printPair();
                    break;
                } else if (confirmation.isBlank()) {
                    System.out.print("Error. Please enter 'y' to confirm or 'n' to try again: ");
                } else System.out.print("Error. Please enter 'y' to confirm or 'n' to try again: ");
            }
        } else if (p1.getWildlifeToken() == p3.getWildlifeToken() && p3.getWildlifeToken() == p4.getWildlifeToken()) {
            System.out.println("There are 3 Wildlife Tokens of the same kind, Would you like to cull them? (y/n)");
            Scanner yn = new Scanner(System.in);
            while (true) {
                String confirmation = yn.nextLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    System.out.println("");
                    possibleW.remove(p1.getWildlifeToken());
                    possibleW.remove(p3.getWildlifeToken());
                    possibleW.remove(p4.getWildlifeToken());

                    p1 = new Pair(possibleW.get(0), possibleT.get(0));
                    p3 = new Pair(possibleW.get(2), possibleT.get(2));
                    p4 = new Pair(possibleW.get(3), possibleT.get(3));

                    p1.printPair();
                    p2.printPair();
                    p3.printPair();
                    p4.printPair();

                    break;
                } else if (confirmation.equalsIgnoreCase("n")) {
                    System.out.println("");
                    p1.printPair();
                    p2.printPair();
                    p3.printPair();
                    p4.printPair();
                    break;
                } else if (confirmation.isBlank()) {
                    System.out.print("Error. Please enter 'y' to confirm or 'n' to try again: ");
                } else System.out.print("Error. Please enter 'y' to confirm or 'n' to try again: ");
            }
        } else if (p1.getWildlifeToken() == p2.getWildlifeToken() && p2.getWildlifeToken() == p4.getWildlifeToken()) {
            System.out.println("There are 3 Wildlife Tokens of the same kind, Would you like to cull them? (y/n)");
            Scanner yn = new Scanner(System.in);
            while (true) {
                String confirmation = yn.nextLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    System.out.println("");
                    possibleW.remove(p1.getWildlifeToken());
                    possibleW.remove(p2.getWildlifeToken());
                    possibleW.remove(p4.getWildlifeToken());

                    p1 = new Pair(possibleW.get(0), possibleT.get(0));
                    p2 = new Pair(possibleW.get(1), possibleT.get(1));
                    p4 = new Pair(possibleW.get(3), possibleT.get(3));

                    p1.printPair();
                    p2.printPair();
                    p3.printPair();
                    p4.printPair();

                    break;
                } else if (confirmation.equalsIgnoreCase("n")) {
                    System.out.println("");
                    p1.printPair();
                    p2.printPair();
                    p3.printPair();
                    p4.printPair();
                    break;
                } else if (confirmation.isBlank()) {
                    System.out.print("Error. Please enter 'y' to confirm or 'n' to try again: ");
                } else System.out.print("Error. Please enter 'y' to confirm or 'n' to try again: ");
            }
        } else if (p2.getWildlifeToken() == p3.getWildlifeToken() && p3.getWildlifeToken() == p4.getWildlifeToken()) {
            System.out.println("There are 3 Wildlife Tokens of the same kind, Would you like to cull them? (y/n)");
            Scanner yn = new Scanner(System.in);
            while (true) {
                String confirmation = yn.nextLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    System.out.println("");
                    possibleW.remove(p2.getWildlifeToken());
                    possibleW.remove(p3.getWildlifeToken());
                    possibleW.remove(p4.getWildlifeToken());

                    p2 = new Pair(possibleW.get(1), possibleT.get(1));
                    p3 = new Pair(possibleW.get(2), possibleT.get(2));
                    p4 = new Pair(possibleW.get(3), possibleT.get(3));

                    p1.printPair();
                    p2.printPair();
                    p3.printPair();
                    p4.printPair();

                    break;
                } else if (confirmation.equalsIgnoreCase("n")) {
                    System.out.println("");
                    p1.printPair();
                    p2.printPair();
                    p3.printPair();
                    p4.printPair();
                    break;
                } else if (confirmation.isBlank()) {
                    System.out.print("Error. Please enter 'y' to confirm or 'n' to try again: ");
                } else System.out.print("Error. Please enter 'y' to confirm or 'n' to try again: ");
            }
        }

        //check to make sure you cant softlock yourself into picking a pair with a wild life token that you will not be able to place on your board
        boolean valid = false;
        Scanner choice = new Scanner(System.in);
        int in = 0;
        while (!valid) {
            in = choice.nextInt();
            System.out.println("");

            //check to make sure you are still able to pick a pair whose tile supports the wildlife token in the pair
            if (p1.getTile().getStringRep().get(1).contains(p1.getWildlifeToken().getAnimalLetter()) || p1.getTile().getStringRep().get(2).contains(p1.getWildlifeToken().getAnimalLetter())
                    || p2.getTile().getStringRep().get(1).contains(p2.getWildlifeToken().getAnimalLetter()) || p2.getTile().getStringRep().get(2).contains(p2.getWildlifeToken().getAnimalLetter())
                    || p3.getTile().getStringRep().get(1).contains(p3.getWildlifeToken().getAnimalLetter()) || p3.getTile().getStringRep().get(2).contains(p3.getWildlifeToken().getAnimalLetter())
                    || p4.getTile().getStringRep().get(1).contains(p4.getWildlifeToken().getAnimalLetter()) || p4.getTile().getStringRep().get(2).contains(p4.getWildlifeToken().getAnimalLetter())) {
                valid = true;
            }

            WildlifeToken w;
            switch (in) {
                case 1 -> w = p1.getWildlifeToken();
                case 2 -> w = p2.getWildlifeToken();
                case 3 -> w = p3.getWildlifeToken();
                case 4 -> w = p4.getWildlifeToken();
                default -> {
                    System.out.println("Choose a number between 1 and 4");
                    continue;
                }
            }

            for (Tile t : b.tiles) {
                if (t.getStringRep().get(1).contains(w.getAnimalLetter()) || t.getStringRep().get(2).contains(w.getAnimalLetter()) && !t.hasWildLifeToken()) {
                    valid = true;
                }
            }
        }

        //returns the pair selected and removes the tiles of that pair from the arrays of possible tiles and possible wildlife
        if (in == 1) {
            possibleT.remove(p1.getTile());
            possibleW.remove(p1.getWildlifeToken());
            return p1;
        } else if (in == 2) {
            possibleT.remove(p2.getTile());
            possibleW.remove(p2.getWildlifeToken());
            return p2;
        } else if (in == 3) {
            possibleT.remove(p3.getTile());
            possibleW.remove(p3.getWildlifeToken());
            return p3;
        } else {
            possibleT.remove(p4.getTile());
            possibleW.remove(p4.getWildlifeToken());
            return p4;
        }
    }

    //just a prompt to choose tile coordinates
    public int[] tileCoordPrompt() throws IOException {

        System.out.println("\n Please choose which coordinates you want to place the tile at (x y):");
        int[] a = new int[2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lines = br.readLine();

        String[] strs = lines.trim().split("\\s+");

        for (int i = 0; i < strs.length; i++) {
            a[i] = Integer.parseInt(strs[i]);
        }
        return a;
    }
    //same as previous
    public int[] tokenCoordPrompt() throws IOException {
        System.out.println("Please choose which coordinates you want to place the token at (x y):");
        int[] a = new int[2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lines = br.readLine();

        String[] strs = lines.trim().split("\\s+");

        for (int i = 0; i < strs.length; i++) {
            a[i] = Integer.parseInt(strs[i]);
        }
        return a;
    }

    //checks to make sure you are able to put a wildlife token on the tile you have selected.
    public boolean checkTileWildlife(int coord1, int coord2, WildlifeToken wt, Board b) {
        Tile t;
        t = b.getTileByCoordinates(coord1, coord2);
        for (Tile bTiles : b.tiles) {
            if (t == null) {
                return true;
            } else if ((bTiles.getX() == coord1 && bTiles.getY() == coord2) && (b.isTokenOccupied(coord1, coord2))) {
                return true;
            } else if (!(Objects.equals(t.getWildlifeChar(0), wt.getAnimalLetter())) && !(Objects.equals(t.getWildlifeChar(1), wt.getAnimalLetter())) && !(Objects.equals(t.getWildlifeChar(2), wt.getAnimalLetter()))) {
                return true;
            }
        }
        return false;
    }


}