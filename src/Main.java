import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        int[] startRand = new Random().ints(5, 1, 5).distinct().toArray();


        starterTile start = new starterTile();
        ArrayList<Tile> firstStarter = start.starterTiles.get(startRand[0]);
        ArrayList<Tile> secStarter = start.starterTiles.get(startRand[1]);
        Prompts prompts = new Prompts();
        Score score = new Score();

        PossibleTiles ps = new PossibleTiles();
        ArrayList<Tile> possibleT = ps.setPossibleTiles();
        PossibleTokens pt = new PossibleTokens();
        ArrayList<WildlifeToken> possibleW = pt.setPossibleTokens();

        Board board1 = new Board();
        Board board2 = new Board();

        //Tests test = new Tests();
        //test.salmonBearTest(board1);

        //test.elkHawkTest(board1);
        //test.foxTest(board2);

        //board1.drawBoard();
        //board2.drawBoard();


        board1.tiles.add(firstStarter.get(0));
        firstStarter.get(0).setCoordinates(0,0);
        firstStarter.get(0).setStringRep();
        
        board1.tiles.add(firstStarter.get(1));
        firstStarter.get(1).setCoordinates(-1,1);
        firstStarter.get(1).setStringRep();
       
        board1.tiles.add(firstStarter.get(2));
        firstStarter.get(2).setCoordinates(0,1);
        firstStarter.get(2).setStringRep();


        board2.tiles.add(secStarter.get(0));
        secStarter.get(0).setCoordinates(0,0);
        secStarter.get(0).setStringRep();

        board2.tiles.add(secStarter.get(1));
        secStarter.get(1).setCoordinates(-1,1);
        secStarter.get(1).setStringRep();

        board2.tiles.add(secStarter.get(2));
        secStarter.get(2).setCoordinates(0,1);
        secStarter.get(2).setStringRep();

        MainMenu.mainMenu();
        String[] currentPlayers = prompts.namePlayersPrompt();
        Turn.turnOrder(currentPlayers);

        for (int i = 0; i < 40; i ++) {
            if ((i & 1) == 0) {
                System.out.println("\nIt is " + currentPlayers[0] + "'s turn\n");
                board1.drawBoard();
                Pair pair1 = prompts.pairPrompt(possibleT, possibleW, board1);

                pair1.getTile().generateStringRep();
                board1.tiles.add(pair1.getTile());
                board1.wildlifeTokens.add(pair1.getWildlifeToken());


                int[] tileCoord1 = prompts.tileCoordPrompt();

                while (!board1.isTilePlacementPossible(tileCoord1[0], tileCoord1[1])) {
                    System.out.println("This coordinate is already taken, or out of bounds");
                    tileCoord1 = prompts.tileCoordPrompt();
                }
                pair1.getTile().setCoordinates(tileCoord1[0], tileCoord1[1]);
                board1.drawBoard();
                System.out.println("\nWildlife Token: " + pair1.getWildlifeToken().getAnimalLetter() + "\n");
                int[] tokenCoord1 = prompts.tokenCoordPrompt();
                while (prompts.checkTileWildlife(tokenCoord1[0], tokenCoord1[1], pair1.getWildlifeToken(), board1)) {
                    System.out.println("The wildlife token is already on a tile, please choose another tile.");
                    tokenCoord1 = prompts.tokenCoordPrompt();
                }
                while (board1.getTileByCoordinates(tokenCoord1[0], tokenCoord1[1]) == null) {
                    System.out.println("Tile does not exist, please try again");
                }
                board1.getTileByCoordinates(tokenCoord1[0], tokenCoord1[1]).setWildlifeToken(pair1.getWildlifeToken());
                pair1.getWildlifeToken().setCoordinates(tokenCoord1[0], tokenCoord1[1]);

                board1.drawBoard();

            } else {
                System.out.println("\nIt is " + currentPlayers[1] + "'s turn\n");
                board2.drawBoard();
                Pair pair2 = prompts.pairPrompt(possibleT, possibleW,board2);

                pair2.getTile().generateStringRep();
                board2.tiles.add(pair2.getTile());
                board2.wildlifeTokens.add(pair2.wildlifeToken);
                int[] tileCoord2 = prompts.tileCoordPrompt();
                while (!board2.isTilePlacementPossible(tileCoord2[0], tileCoord2[1])) {
                    System.out.println("This coordinate is already taken, or out of bounds");
                    tileCoord2 = prompts.tileCoordPrompt();
                }
                pair2.getTile().setCoordinates(tileCoord2[0], tileCoord2[1]);
                board2.drawBoard();
                System.out.println("\nWildlife Token: " + pair2.getWildlifeToken().getAnimalLetter() + "\n");
                int[] tokenCoord2 = prompts.tokenCoordPrompt();
                while (prompts.checkTileWildlife(tokenCoord2[0], tokenCoord2[1], pair2.getWildlifeToken(), board2)) {
                    System.out.println("This wildlife token is already on a tile, please choose another tile.");
                    tokenCoord2 = prompts.tokenCoordPrompt();
                }
                while (board2.getTileByCoordinates(tokenCoord2[0], tokenCoord2[1]) == null) {
                    System.out.println("Tile does not exist, please try again");
                }
                board2.getTileByCoordinates(tokenCoord2[0], tokenCoord2[1]).setWildlifeToken(pair2.getWildlifeToken());
                pair2.getWildlifeToken().setCoordinates(tokenCoord2[0], tokenCoord2[1]);

                board2.drawBoard();
            }
        }

        int[] playerScores = new int[2];
        playerScores[0] = score.getTotalScore(board1);
        playerScores[1] = score.getTotalScore(board2);

        int[] playerScoresBear = new int[2];
        playerScoresBear[0] = score.BearScoringCard(board1);
        playerScoresBear[1] = score.BearScoringCard(board2);

        int[] playerScoresHawk = new int[2];
        playerScoresHawk[0] = score.HawkScoringCard(board1);
        playerScoresHawk[1] = score.HawkScoringCard(board2);

        int[] playerScoresSalmon = new int[2];
        playerScoresSalmon[0] = score.SalmonScoringCard(board1);
        playerScoresSalmon[1] = score.SalmonScoringCard(board2);

        int[] playerScoresFox = new int[2];
        playerScoresFox[0] = score.FoxScoringCard(board1);
        playerScoresFox[1] = score.FoxScoringCard(board2);

        int[] playerScoresElk = new int[2];
        playerScoresElk[0] = score.ElkScoringCard(board1);
        playerScoresElk[1] = score.ElkScoringCard(board2);

        int[] natureTokens = new int[2];
        natureTokens[0] = score.natureTokenScore(board1);
        natureTokens[1] = score.natureTokenScore(board2);
        
        score.printScore(currentPlayers, playerScoresBear, playerScoresHawk, playerScoresElk, playerScoresSalmon, playerScoresFox, playerScores, natureTokens);

    }

    public static void exit() {
            System.out.println("\nTerminating the program, please wait...\n");
            System.exit(0);
        }
    }