package io.github.aleksandras_sivkovas.game.dragons.backend.data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AD")
public class Ad {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String message;
	private String reward;
	@Column(name = "appear_turn")
	private int appearTurn;
	@Column(name = "expire_turn")
	private int expireTurn;
	@Column(name = "points_for_tasks")
	private int pointsForTask;
	@Column(name = "dificulty")
	private int difficulty;
	
	@OneToMany(mappedBy = "ad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompletedAd> completedAds;
	
	public Ad() {
		super();
	}

	public String getId() {
		return id;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public int getAppearTurn() {
		return appearTurn;
	}

	public void setAppearTurn(int appearTurn) {
		this.appearTurn = appearTurn;
	}

	public int getExpireTurn() {
		return expireTurn;
	}

	public void setExpireTurn(int expireTurn) {
		this.expireTurn = expireTurn;
	}

	public int getPointsForTask() {
		return pointsForTask;
	}

	public void setPointsForTask(int pointsForTask) {
		this.pointsForTask = pointsForTask;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	

}
