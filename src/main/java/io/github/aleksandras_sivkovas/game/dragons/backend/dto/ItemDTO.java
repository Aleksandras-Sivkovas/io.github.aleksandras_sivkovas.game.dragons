package io.github.aleksandras_sivkovas.game.dragons.backend.dto;


public class ItemDTO {
	private final String id;
	private final String name;
	private int gold;
	
	public ItemDTO(
			String id,
			String name,
			int gold
	) {
        this.id = id;
        this.name = name;
        this.gold = gold;
    }
	
	/**
	 * @return Item unique identifier
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return Item name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Item cost in gold
	 */
	public int getGold() {
		return gold;
	}

	
	
}
