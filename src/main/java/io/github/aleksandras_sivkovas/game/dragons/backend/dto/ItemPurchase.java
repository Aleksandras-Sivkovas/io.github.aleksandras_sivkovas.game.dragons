package io.github.aleksandras_sivkovas.game.dragons.backend.dto;

public class ItemPurchase {
	private final String shoppingSuccess;
	private final int gold;
	private final int lives;
	private final int level;
	private final int turn;
	
	public ItemPurchase(
			String shoppingSuccess,
			int gold,
			int lives,
			int level,
			int turn
	) {
        this.shoppingSuccess = shoppingSuccess;
        this.gold = gold;
        this.lives = lives;
        this.level = level;
        this.turn = turn;
    }
	
	/**
	 * @return Whether or not the purchase was successful
	 */
	public String getShoppingSuccess() {
		return shoppingSuccess;
	}

	/**
	 * @return Amount of gold left after the transaction.
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * @return Amount of lives left after the transaction
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * @return Dragon level after transaction
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @return Current turn. Note the turn increases even if the purchase is unsuccessful.
	 */
	public int getTurn() {
		return turn;
	}
	
	
	
}
