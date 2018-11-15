package io.github.aleksandras_sivkovas.game.dragons.backend.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPLETED_AD")
@IdClass(CompletedAdId.class)
public class CompletedAd implements Serializable{
	private static final long serialVersionUID = 8768773798669019722L;

	@Id
    @ManyToOne
    private Game game;

    @Id
    @ManyToOne
    private Ad ad;
    
    
    public CompletedAd() {
    	super();
    }


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}


	public Ad getAd() {
		return ad;
	}


	public void setAd(Ad ad) {
		this.ad = ad;
	}


}
