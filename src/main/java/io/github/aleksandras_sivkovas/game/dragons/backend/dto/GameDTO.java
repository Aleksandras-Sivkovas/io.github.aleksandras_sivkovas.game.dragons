package io.github.aleksandras_sivkovas.game.dragons.backend.dto;

public class GameDTO {
	
	private final String gameId;
	private final int lives;
	private final int gold;
	private final int level;
	private final int score;
	private final int highScore;
	private final int turn;
	
	public GameDTO(
			String gameId,
			int lives,
			int gold,
			Long boughtItemsAbility,
			int score,
			int highScore,
			int turn
	) {
        this.gameId = gameId;
        this.lives = lives;
        this.gold = gold;
        this.level = boughtItemsAbility == null ? 
        		1 :
        		boughtItemsAbility.intValue() + 1;
        this.score = score;
        this.highScore = highScore;
        this.turn = turn;
    }

	public String getGameId() {
		return gameId;
	}

	public int getLives() {
		return lives;
	}

	public int getGold() {
		return gold;
	}

	public int getLevel() {
		return level;
	}

	public int getScore() {
		return score;
	}

	public int getHighScore() {
		return highScore;
	}

	public int getTurn() {
		return turn;
	}
	
	
	
}
