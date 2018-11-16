package io.github.aleksandras_sivkovas.game.dragons.backend.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

//@Repository
public class GameRepositoryCustomImpl implements GameRepositoryCustom{

	
	@Autowired
	private GameRepositoryBasic gameRepository;
	
	
	@Override
	public int findGameLevel(String gameId) {
		Optional<Integer> ability = gameRepository.getBoughtItemsAbility(gameId);
		
		return ability.isPresent() 
				? 1 + ability.get()
				:1;
	}
}
