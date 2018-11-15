package io.github.aleksandras_sivkovas.game.dragons.backend.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepositoryCustomImpl implements GameRepositoryCustom{

	@Autowired
	private ItemRepository itemRemository;
	
	@Override
	public int findGameLevel(String gameId) {
		Optional<Integer> ability = itemRemository.getBoughtItemsAbility(gameId);
		
		return ability.isPresent() 
				? 1 + ability.get()
				:1;
	}
}
