import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Score {

    //NOTE: I was mostly done the scoring of Wildlife Cards A, mentioned in the original copy of the assignment,
    // before downloading and seeing the updated resit assignment, which i wasnt aware took out the A cards.
    // due to having little time left to work on these cards, I decided just to finish the A cards to the best of my ability,
    // I apologise for this mistake. I also did not have the time to write the corridor scoring, unfortunately.

    public Score() {

    }

    public int getTotalScore (Board b) {
        int bear = BearScoringCard(b);
        int hawk = HawkScoringCard(b);
        int elk = ElkScoringCard(b);
        int fox = FoxScoringCard(b);
        int salmon = SalmonScoringCard(b);
        int nature = natureTokenScore(b);

        return bear + hawk + elk + fox + salmon + nature;
    }

    //bear scoring card
    /*
        this one wasnt too bad. it simply checks the if a tile has a bear wildlife token, if the tile top right of it
        has a bear wildlife token, and then makes sure the tiles around the pair dont have a bear wildlife token
     */
    public int BearScoringCard(Board b) {
        int sum = 0;
        int ret = 0;
        for (Tile t : b.tiles) {
            boolean flag = false;
            if (t.getWt() == null) {
                continue;

            } else if (t.getWt().getAnimalLetter().equals("B")) {
                int x = t.getX();
                int y = t.getY();
                if ((y & 1) == 0) {
                    Tile topRight = b.getTileByCoordinates(x, y - 1);
                    if (topRight == null || topRight.getWt() == null) {
                        continue;
                    } else if (topRight.getWt().getAnimalLetter().equals("B")) {
                        ArrayList<ArrayList<Integer>> coords = new ArrayList<>();
                        coords.add(new ArrayList<>(Arrays.asList(x + 1, y - 2)));
                        coords.add(new ArrayList<>(Arrays.asList(x + 1, y -1)));
                        coords.add(new ArrayList<>(Arrays.asList(x + 1, y)));
                        coords.add(new ArrayList<>(Arrays.asList(x, y + 1)));
                        coords.add(new ArrayList<>(Arrays.asList(x - 1, y + 1)));
                        coords.add(new ArrayList<>(Arrays.asList(x - 1, y)));
                        coords.add(new ArrayList<>(Arrays.asList(x - 1, y - 1)));
                        coords.add(new ArrayList<>(Arrays.asList(x, y - 2)));
                        for (ArrayList<Integer> c : coords) {
                            if (b.getTileByCoordinates(c.get(0), c.get(1)) == null || b.getTileByCoordinates(c.get(0), c.get(1)).getWt() == null) {
                                continue;
                            }
                            if (b.getTileByCoordinates(c.get(0), c.get(1)).getWt() == null || !b.getTileByCoordinates(c.get(0), c.get(1)).getWt().getAnimalLetter().equals("B")) {
                                flag = true;
                            }
                        }

                    }

                } else {
                    Tile topRight = b.getTileByCoordinates(x + 1, y - 1);
                    if (topRight == null || topRight.getWt() == null) {
                        continue;
                    } else if (topRight.getWt().getAnimalLetter().equals("B")) {
                        ArrayList<ArrayList<Integer>> coords = new ArrayList<>();
                        coords.add(new ArrayList<>(Arrays.asList(x - 1, y)));
                        coords.add(new ArrayList<>(Arrays.asList(x, y - 1)));
                        coords.add(new ArrayList<>(Arrays.asList(x, y - 2)));
                        coords.add(new ArrayList<>(Arrays.asList(x + 1, y - 2)));
                        coords.add(new ArrayList<>(Arrays.asList(x + 1, y + 1)));//
                        coords.add(new ArrayList<>(Arrays.asList(x + 2, y - 1)));
                        coords.add(new ArrayList<>(Arrays.asList(x + 1, y)));
                        coords.add(new ArrayList<>(Arrays.asList(x, y + 1)));//
                        for (ArrayList<Integer> c : coords) {
                            if (b.getTileByCoordinates(c.get(0), c.get(1)) == null || b.getTileByCoordinates(c.get(0), c.get(1)).getWt() == null) {
                                continue;
                            }
                            if (b.getTileByCoordinates(c.get(0), c.get(1)).getWt() == null || !b.getTileByCoordinates(c.get(0), c.get(1)).getWt().getAnimalLetter().equals("B")) {
                                flag = true;
                            }
                        }

                    }
                }
            }
            if (flag) {
                sum++;
            }

            ret = switch (sum) {
                case 1 -> 4;
                case 2 -> 11;
                case 3 -> 19;
                case 4 -> 27;
                default -> 0;
            };

        }
        return ret;
    }

    /*
        the nicest and easiest of the scoring cards, checks if a tile is a hawk, makes sure none of the tiles around it are hawks
     */
    public int HawkScoringCard(Board b) {
        int sum = 0;
        int ret = 0;
        for (Tile t : b.tiles) {
            boolean flag = false;
            if (t.getWt() == null) {
                continue;
            } else if (t.getWt().getAnimalLetter().equals("H")) {
                int x = t.getX();
                int y = t.getY();

                if ((y & 1) == 0) {

                    ArrayList<ArrayList<Integer>> coords = new ArrayList<>();
                    coords.add(new ArrayList<>(Arrays.asList(x + 1, y - 1)));
                    coords.add(new ArrayList<>(Arrays.asList(x + 1, y)));
                    coords.add(new ArrayList<>(Arrays.asList(x, y + 1)));
                    coords.add(new ArrayList<>(Arrays.asList(x - 1, y + 1)));
                    coords.add(new ArrayList<>(Arrays.asList(x - 1, y)));
                    coords.add(new ArrayList<>(Arrays.asList(x, y - 1)));
                    for (ArrayList<Integer> c : coords) {
                        if (b.getTileByCoordinates(c.get(0), c.get(1)) == null) {
                            continue;
                        }
                        if (b.getTileByCoordinates(c.get(0), c.get(1)).getWt() == null || !b.getTileByCoordinates(c.get(0), c.get(1)).getWt().getAnimalLetter().equals("H")) {
                            flag = true;
                        }
                    }
                } else {
                    ArrayList<ArrayList<Integer>> coords = new ArrayList<>();
                    coords.add(new ArrayList<>(Arrays.asList(x + 1, y - 1)));
                    coords.add(new ArrayList<>(Arrays.asList(x + 1, y)));
                    coords.add(new ArrayList<>(Arrays.asList(x + 1, y + 1)));
                    coords.add(new ArrayList<>(Arrays.asList(x, y + 1)));
                    coords.add(new ArrayList<>(Arrays.asList(x - 1, y)));
                    coords.add(new ArrayList<>(Arrays.asList(x, y - 1)));
                    for (ArrayList<Integer> c : coords) {
                        if (b.getTileByCoordinates(c.get(0), c.get(1)) == null) {
                            continue;
                        }
                        if (b.getTileByCoordinates(c.get(0), c.get(1)).getWt() == null || !b.getTileByCoordinates(c.get(0), c.get(1)).getWt().getAnimalLetter().equals("H")) {
                            flag = true;
                        }
                    }
                }
                if (flag) {
                    sum++;
                }
            }

            ret = switch (sum) {
                case 1 -> 2;
                case 2 -> 5;
                case 3 -> 8;
                case 4 -> 11;
                case 5 -> 14;
                case 6 -> 18;
                case 7 -> 22;
                case 8 -> 26;
                default -> 0;
            };
        }
        return ret;
    }

    /*
        slight challenge, checks if tile is a fox naturally, then using a hashset counts all the unique tokens around the fox
     */
    public int FoxScoringCard(Board b) {
        int sum = 0;
        for (Tile t : b.tiles) {
            if (t.getWt() == null) {
                continue;
            } else if (t.getWt().getAnimalLetter().equals("F")) {
                int x = t.getX();
                int y = t.getY();

                if ((y & 1) == 0) {
                    /* Check for connection to adjacent tiles */
                    ArrayList<ArrayList<Integer>> coords = new ArrayList<>();
                    coords.add(new ArrayList<>(Arrays.asList(x - 1, y - 1)));
                    coords.add(new ArrayList<>(Arrays.asList(x, y - 1)));
                    coords.add(new ArrayList<>(Arrays.asList(x+ 1, y)));
                    coords.add(new ArrayList<>(Arrays.asList(x, y + 1)));
                    coords.add(new ArrayList<>(Arrays.asList(x - 1, y + 1)));
                    coords.add(new ArrayList<>(Arrays.asList(x - 1, y)));

                    HashSet<String> uniqueTokens = new HashSet<>();

                    for (ArrayList<Integer> coord : coords) {
                        Tile adjacentTile = b.getTileByCoordinates(coord.get(0), coord.get(1));
                        if (adjacentTile != null && adjacentTile.getWt() != null) {
                            uniqueTokens.add(adjacentTile.getWt().getAnimalLetter());
                        }
                    }
                    // Subtract 1 because the "Fox" tile itself is also counted
                    sum += uniqueTokens.size() - 1;

                } else {
                    ArrayList<ArrayList<Integer>> coords = new ArrayList<>();
                    coords.add(new ArrayList<>(Arrays.asList(x + 1, y - 1)));
                    coords.add(new ArrayList<>(Arrays.asList(x + 1, y)));
                    coords.add(new ArrayList<>(Arrays.asList(x + 1, y + 1)));
                    coords.add(new ArrayList<>(Arrays.asList(x, y + 1)));
                    coords.add(new ArrayList<>(Arrays.asList(x - 1, y)));
                    coords.add(new ArrayList<>(Arrays.asList(x, y - 1)));

                    HashSet<String> uniqueTokens = new HashSet<>();

                    for (ArrayList<Integer> coord : coords) {
                        Tile adjacentTile = b.getTileByCoordinates(coord.get(0), coord.get(1));
                        if (adjacentTile != null && adjacentTile.getWt() != null) {
                            uniqueTokens.add(adjacentTile.getWt().getAnimalLetter());
                        }
                    }

                    sum += uniqueTokens.size() - 1;

                }
            }
        }

        return sum;
    }

    /*
        fairly straight forward. checks if tile is an elk, looks to the left of the tile, looks to the right of the tile and checks if theyre elk or not.
    */
    public int ElkScoringCard(Board b) {
        int ret = 0;
        ArrayList<Tile> found = new ArrayList<>();
        for (Tile t : b.tiles) {
            if (found.contains(t)) continue;

            if (t.getWt() == null) continue;



            if (t.getWt().getAnimalLetter().equals("E")) {
                int x = t.getX();
                int y = t.getY();

                int length = 1;
                int i = 1;

                found.add(t);

                /* Move left */
                Tile lt = b.getTileByCoordinates(x - i, y);

                while (lt != null && lt.getWt() != null && lt.getWt().getAnimalLetter().equals("E")) {
                    found.add(lt);
                    length++;
                    i++;
                    lt = b.getTileByCoordinates(x - i, y);
                }

                i = 1;
                Tile rt = b.getTileByCoordinates(x + i, y);

                while (rt != null && rt.getWt() != null && rt.getWt().getAnimalLetter().equals("E")) {
                    found.add(rt);
                    length++;
                    i++;
                    rt = b.getTileByCoordinates(x + i, y);
                }


                ret += switch (length) {
                    case 1 -> 2;
                    case 2 -> 5;
                    case 3 -> 9;
                    case 4 -> 13;
                    default -> 0;
                };
            }
        }
        return ret;
    }
/*
     the bane of my sanity. this card took me quite a while to write. it checks if the tile is a salmon, checks if the tiles in the order of the card are salmon
     then checks to make sure the tiles around which are not meant to be salmon, arent salmon. all according to the picture in the games rules.
 */
    public int SalmonScoringCard(Board b) {
        int score = 0;
        int sum = 0;
        ArrayList<Tile> found = new ArrayList<>();
        for (Tile t : b.tiles) {

            if (found.contains(t)) continue;

            if (t.getWt() == null) continue;

            if (t.getWt().getAnimalLetter().equals("S")) {

                int x = t.getX();
                int y = t.getY();
                boolean flag = true;
                //Tile t2 = null, t3 = null, t4 = null, t5 = null, t6 = null, t7 = null;
                Tile[] salmonTiles = new Tile[7];
                ArrayList<ArrayList<Integer>> coords = new ArrayList<>();

                if ((y & 1) == 0) {
                    //coords of all the tiles which cannot be salmon
                    //ArrayList<ArrayList<Integer>> coords = new ArrayList<>();
                    coords.add(new ArrayList<>(Arrays.asList(x + 1, y))); // 0
                    coords.add(new ArrayList<>(Arrays.asList(x + 2, y))); // 1
                    coords.add(new ArrayList<>(Arrays.asList(x + 5, y))); // 2

                    coords.add(new ArrayList<>(Arrays.asList(x - 1, y + 1))); // 3
                    coords.add(new ArrayList<>(Arrays.asList(x + 3, y + 1))); // 4

                    coords.add(new ArrayList<>(Arrays.asList(x, y + 2))); // 5
                    coords.add(new ArrayList<>(Arrays.asList(x + 1, y + 2))); // 6
                    coords.add(new ArrayList<>(Arrays.asList(x + 2, y + 2))); // 7
                    coords.add(new ArrayList<>(Arrays.asList(x + 3, y + 2))); // 8


                    //all the tiles which should be salmon in order
                    //  1               5   6
                    //      2   3   4           7
                    salmonTiles[0] = t;
                    salmonTiles[1] = b.getTileByCoordinates(x, y + 1);
                    salmonTiles[2] = b.getTileByCoordinates(x + 1, y + 1);
                    salmonTiles[3] = b.getTileByCoordinates(x + 2, y + 1);
                    salmonTiles[4] = b.getTileByCoordinates(x + 3, y);
                    salmonTiles[5] = b.getTileByCoordinates(x + 4, y);
                    salmonTiles[6] = b.getTileByCoordinates(x + 4, y + 1);

                } else {
                    // Odd row
                    //ArrayList<ArrayList<Integer>> coords = new ArrayList<>();
                    coords.add(new ArrayList<>(Arrays.asList(x + 1, y))); // 0
                    coords.add(new ArrayList<>(Arrays.asList(x + 2, y))); // 1
                    coords.add(new ArrayList<>(Arrays.asList(x + 5, y))); // 2
                    coords.add(new ArrayList<>(Arrays.asList(x, y + 1))); // 3
                    coords.add(new ArrayList<>(Arrays.asList(x + 4, y + 1))); // 4
                    coords.add(new ArrayList<>(Arrays.asList(x, y + 2))); // 5
                    coords.add(new ArrayList<>(Arrays.asList(x + 1, y + 2))); // 6
                    coords.add(new ArrayList<>(Arrays.asList(x + 2, y + 2))); // 7
                    coords.add(new ArrayList<>(Arrays.asList(x + 3, y + 2))); // 8

                    salmonTiles[0] = t;
                    salmonTiles[1] = b.getTileByCoordinates(x + 1, y + 1);
                    salmonTiles[2] = b.getTileByCoordinates(x + 2, y + 1);
                    salmonTiles[3] = b.getTileByCoordinates(x + 3, y + 1);
                    salmonTiles[4] = b.getTileByCoordinates(x + 3, y);
                    salmonTiles[5] = b.getTileByCoordinates(x + 4, y);
                    salmonTiles[6] = b.getTileByCoordinates(x + 5, y + 1);

                }
                //Tile[] salmonTiles = {t, t2, t3, t4, t5, t6, t7};
                for (Tile salmonTile : salmonTiles) {
                    if (salmonTile != null && salmonTile.getWt() != null && salmonTile.getWt().getAnimalLetter().equals("S")) {
                    for (ArrayList<Integer> coord : coords) {
                        Tile adjacentTile = b.getTileByCoordinates(coord.get(0), coord.get(1));
                        if (adjacentTile != null && adjacentTile.getWt() != null && adjacentTile.getWt().getAnimalLetter().equals("S")) {
                            flag = false;
                            break;
                        }

                    }

                    if (flag) {
                        score++;
                    } else {
                        break;
                    }

                } else {
                        flag = false;
                        break;// Break out of the outer loop
                    }


                 // Increase the score if the salmon tiles are in the correct order and not adjacent to the restricted coordinates
                }

                // Add all salmon tiles to the found list
                for (Tile salmonTile : salmonTiles) {
                    found.add(salmonTile);
                }
            }
        }
        sum += switch (score) {
            case 1 -> 2;
            case 2 -> 5;
            case 3 -> 8;
            case 4 -> 12;
            case 5 -> 16;
            case 6 -> 20;
            case 7 -> 25;
            default -> 0;
        };
            return sum;
    }

    //nature token score
    public int natureTokenScore (Board b) {
        int i = 0;
        for (Tile t : b.tiles) {
            if (t.getKeystone() == 1 && t.hasWildLifeToken()) {
                i++;
            }
        }
        return i;
    }

    //the table which prints score, there is unfortunately a problem where the score numbers dont line up properly if one of the numbers is double digits.
    public void printScore (String[] players, int[] bear, int[] hawk, int[] elk, int[] salmon, int[] fox, int[] playerScore, int[] natureTokens) {
        System.out.println("PLAYERS \t \t " + players[0] +  " \t \t \t " + players[1]);
        System.out.println("------------------------------------------------------------\n");
        System.out.println("Bear \t \t \t " + bear[0] + " \t \t \t " + bear[1]);
        System.out.println("Hawk \t \t \t " + hawk[0] + " \t \t \t " + hawk[1]);
        System.out.println("Elk \t \t \t " + elk[0] + " \t \t \t " + elk[1]);
        System.out.println("Salmon \t \t \t " + salmon[0] + " \t \t \t " + salmon[1]);
        System.out.println("Fox \t \t \t " + fox[0] + " \t \t \t " + fox[1] + " \n");

        System.out.println("Nature Tokens \t " + natureTokens[0] + " \t \t \t " + natureTokens[1] + " \n");

        System.out.println("*************************************************************\n");
        System.out.println("FINAL SCORE \t " + playerScore[0] + " \t \t \t " + playerScore[1]);
        System.out.println("*************************************************************\n");
    }
}
