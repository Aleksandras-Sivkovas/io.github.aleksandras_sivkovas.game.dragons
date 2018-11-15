package io.github.aleksandras_sivkovas.game.dragons.backend.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOUGHT_ITEM")
@IdClass(BoughtItemId.class)
public class BoughtItem  implements Serializable{
	private static final long serialVersionUID = -9174370015153265128L;

	@Id
    @ManyToOne
    private Game game;

    @Id
    @ManyToOne
    private Item item;
    
    
    public BoughtItem() {
    	super();
    }


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}
}
