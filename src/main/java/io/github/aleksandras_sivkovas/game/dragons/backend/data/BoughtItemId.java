package io.github.aleksandras_sivkovas.game.dragons.backend.data;

import java.io.Serializable;
import java.util.Objects;

public class BoughtItemId implements Serializable {

	private static final long serialVersionUID = -7058914145644450176L;
	private String game;
	private String item;
 
	public BoughtItemId() {
 
	}
 
	public BoughtItemId(String gameId, String itemId) {
		this.game = gameId;
		this.item = itemId;
	}
 
	@Override
	public int hashCode() {
		return Objects.hash(game, item);
	}
 
	@Override
	public boolean equals(Object o) {
		if (o == this) {
            return true;
        }
        if (!(o instanceof BoughtItemId)) {
            return false;
        }
        BoughtItemId assignedRole = (BoughtItemId) o;
        return Objects.equals(game, assignedRole.getGame()) &&
               Objects.equals(item, assignedRole.getItem());
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

}
