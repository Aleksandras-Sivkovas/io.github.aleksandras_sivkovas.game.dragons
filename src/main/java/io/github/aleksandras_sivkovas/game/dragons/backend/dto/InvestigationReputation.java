package io.github.aleksandras_sivkovas.game.dragons.backend.dto;

public class InvestigationReputation {
	
	private final long people;
	private final long state;
	private final long underworld;
	
	public InvestigationReputation(
			long people,
			long state,
			long underworld
	) {
        this.people = people;
        this.state = state;
        this.underworld = underworld;
    }
	
	public long getPeople() {
		return people;
	}

	public long getState() {
		return state;
	}

	public long getUnderworld() {
		return underworld;
	}
	
}
