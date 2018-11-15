package io.github.aleksandras_sivkovas.game.dragons.backend.dto;

public class TaskSolveResult {
	
	private final boolean success;
	private final int lives;
	private final int gold;
	private final int score;
	private final int highScore;
	private final int turn;
	private final String message;
	
	public TaskSolveResult(
			boolean success,
			int lives,
			int gold,
			int score,
			int highScore,
			int turn,
			String message
	) {
        this.success = success;
        this.lives = lives;
        this.gold = gold;
        this.score = score;
        this.highScore = highScore;
        this.turn = turn;
        this.message = message;
    }

	public boolean getSuccess() {
		return success;
	}

	public int getLives() {
		return lives;
	}

	public int getGold() {
		return gold;
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

	public String getMessage() {
		return message;
	}
	

}
