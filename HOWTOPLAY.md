# Cascadia Board Game in Java

### GOAL OF GAME
* Create the most diverse enviroment using *Habitat Tiles* and *WildLife Tokens*.

### GAME COMPONENTS
* 85 HABITAT_TILES (Forest, Wetland, River, Mountain, Prairie and 25 keystones)
* 5 STARTER_HABITAT_TILES
* 100 WILDLIFE_TOKENS (20 Hawk, 20 Bear, 20 Elk, 20 Salmon, 20 Fox)
* 15 WILDLIFE_SCORING_CARDS (3 Hawk, 3 Elk, 3 Fox, 3 Salmon, 3 Bear)
* 20 NATURE_TOKENS
* 1 CLOTH_BAG for WILDLIFE_TOKENS
* 1 SCORE_PAD

### GAME SETUP
1. Place all WILDLIFE_TOKENS in the CLOTH_BAG and shuffle them.
2. Determine how many HABITAT_TILES based on player count.

	| Player Count |   Habitat Tiles   |
	| :----------: | :---------------: |
	|      2       | 43 (or remove 42) |
	|      3       | 63 (or remove 22) |
	|      4       | 83 (or remove 2)  |

* NOTE: 20 HABITAT_TILES per player + 3
* NOTE: This game only supports 2 players.
3. Randomly choose 1 WILDLIFE_SCORING_CARD for each the 5 wildlife.*
4. Randomly distribute 1 STARTER_HABITAT_TILE to each player (facing up). Place others back into box (won't be used).
5. Reveal 4 HABITAT_TILES from the face-down stacks and place them face up within reach of all players.
6. Draw 4 WILDLIFE_TOKENS from CLOTH_BAG pair them with each of the 4 HABITAT_TILES in order.
7. Place NATURE_TOKENS within easy reach of all players.
8. Player who recently saw one of the wildlife in the game will be the first player OR randomly select first player
* NOTE * : This game only supports the A WILDLIFE_SCORING_CARD.

### GAMEPLAY
1. Beginning from starting player and going clockwise to the next player.
2. Players will take turns selecting a HABITAT_TILE and a WILD_LIFE TOKEN and play them into the enviroment.
3. At end of players turn, both the HABITAT_TILE and WILDLIFE_TOKEN selected will be replaced with new ones from HABITAT_TILE stack and CLOTH_BAG respectively.
4. Game ends when there are no more HABITAT_TILES available to replace one selected by player.
5. Proceed to final scoring.
6. NOTE: Each player will have exactly 20 turns.

### ENDGAME
* Record scores on the SCORE_PAD for the following:
1. WILDLIFE_SCORING_CARDS (based on wild life scoring cards).
2. NATURE_TOKENS (score 1 point for each UNUSED nature token).
3. HABITAT_TILES (for each player, score 1 point per HABITAT_TILE in their largest contiguous habitat corridor group. 
	Tiles are included in a contiguous habitat corridor if they share atleast 1 matching edge out of the six edges).*
4. HABITAT_TILE Majorities (find largest habitat corridor for each of the 5 habitats).*
	* 3 to 4 player game - Award 3 points to the largest corridor and 1 point for second largest.
	* 2 player game - Award 2 points to largest corridor and 0 points to the second largest.
	* **TIE:**
		* 3 to 4 player game - If 2 players tie, award 2 points to both of them. If 3 or 4 playrs tie, award 1 point.
		* 2 player game - 1 point each.
5. Tally all points from each player. The player with most points wins.
6. If it's a tie, the player with most NATURE_TOKENS wins.
+ NOTE * : This game does not support these scoring systems