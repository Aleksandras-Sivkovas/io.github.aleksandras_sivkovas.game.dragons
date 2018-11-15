package io.github.aleksandras_sivkovas.game.dragons.backend.data;

import java.io.Serializable;
import java.util.Objects;

public class CompletedAdId implements Serializable {

	private static final long serialVersionUID = -7058914145644450176L;
	private String game;
	private String ad;
 
	public CompletedAdId() {
 
	}
 
	public CompletedAdId(String gameId, String adId) {
		this.game = gameId;
		this.ad = adId;
	}
 
	@Override
	public int hashCode() {
		return Objects.hash(game, ad);
	}
 
	@Override
	public boolean equals(Object o) {
		if (o == this) {
            return true;
        }
        if (!(o instanceof CompletedAdId)) {
            return false;
        }
        CompletedAdId assignedRole = (CompletedAdId) o;
        return Objects.equals(game, assignedRole.getGame()) &&
               Objects.equals(ad, assignedRole.getAd());
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}
 
	
	
}
