package io.github.aleksandras_sivkovas.game.dragons.backend.dto;

public class AdDTO {
	
	private final String adId;
	private final String message;
	private final String reward;
	private final int expiresIn;
	
	public AdDTO(
			String adId,
			String message,
			String reward,
			int expiresIn
	) {
        this.adId = adId;
        this.message = message;
        this.reward = reward;
        this.expiresIn = expiresIn;
    }

	public String getAdId() {
		return adId;
	}

	public String getMessage() {
		return message;
	}

	public String getReward() {
		return reward;
	}

	public int getExpiresIn() {
		return expiresIn;
	}
	
	
	
}
