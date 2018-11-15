package io.github.aleksandras_sivkovas.game.dragons.backend.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.aleksandras_sivkovas.game.dragons.backend.data.Ad;
import io.github.aleksandras_sivkovas.game.dragons.backend.data.BoughtItem;
import io.github.aleksandras_sivkovas.game.dragons.backend.data.BoughtItemId;
import io.github.aleksandras_sivkovas.game.dragons.backend.data.CompletedAd;
import io.github.aleksandras_sivkovas.game.dragons.backend.data.CompletedAdId;
import io.github.aleksandras_sivkovas.game.dragons.backend.data.Game;
import io.github.aleksandras_sivkovas.game.dragons.backend.data.Item;
import io.github.aleksandras_sivkovas.game.dragons.backend.dto.ItemPurchase;
import io.github.aleksandras_sivkovas.game.dragons.backend.dto.TaskSolveResult;
import io.github.aleksandras_sivkovas.game.dragons.backend.exception.BadRequestException;
import io.github.aleksandras_sivkovas.game.dragons.backend.repository.AdRepository;
import io.github.aleksandras_sivkovas.game.dragons.backend.repository.BoughtItemRepository;
import io.github.aleksandras_sivkovas.game.dragons.backend.repository.CompletedAdRepository;
import io.github.aleksandras_sivkovas.game.dragons.backend.repository.GameRepository;
import io.github.aleksandras_sivkovas.game.dragons.backend.repository.ItemRepository;

@Service
public class DragonsService {
	
	@Autowired
    private GameRepository gameRepository;
	
	@Autowired
	private AdRepository adRepository;
	
	@Autowired
	private CompletedAdRepository completedAdRepository;
	
	@Autowired
	private ItemRepository itemrepository;
	
	@Autowired
	private BoughtItemRepository boughtItemRepository;
	
	@Transactional
	public String createNewGame() {
		Game game = new Game();
		game = gameRepository.save(game);
		return game.getId();
	}
	
	@Transactional
	public TaskSolveResult solveAd(String gameId,String adId) {
		if(isAdAlreadyCompleted(gameId, adId)) {
			throw new BadRequestException("Ad '" + adId 
					+ "' is is already completed in game '" 
					+ gameId + "'"
			);
		}
		Ad ad = adRepository.findById(adId).get();
		Game game = gameRepository.findById(gameId).get();
		if(!((game.getTurn() >= ad.getAppearTurn()) && (game.getTurn() <= ad.getExpireTurn()))) {
			throw new BadRequestException("Ad '" + adId 
					+ "' is is expired in game '" 
					+ gameId + "'"
			);
		}
		Integer gameLevel = gameRepository.findGameLevel(gameId);
		if(gameLevel < ad.getDifficulty()) {
			return failSolveAd(gameId, adId);
		}
		game.setTurn(game.getTurn() + 1);
		game.setScore(game.getScore() + ad.getPointsForTask());
		game.setGold(game.getGold() + Integer.valueOf(ad.getReward()));
		CompletedAd completedAd = new CompletedAd();
		completedAd.setAd(ad);
		completedAd.setGame(game);
		completedAdRepository.save(completedAd);
		return new TaskSolveResult(
				true,
				game.getLives(),
				game.getGold(),
				game.getScore(),
				gameRepository.findHighScore().orElse(0),
				game.getTurn(),
				"Task was completed. Points got: " 
				+ ad.getPointsForTask()
				+ " gold got: " 
				+ ad.getReward()
		);
	}
	
	private TaskSolveResult failSolveAd(String gameId,String adId) {
		Game game = gameRepository.findById(gameId).get();
		game.setTurn(game.getTurn() + 1);
		game.setLives(game.getLives() - 1);
		gameRepository.save(game);
		return new TaskSolveResult(
				false,
				game.getLives(),
				game.getGold(),
				game.getScore(),
				gameRepository.findHighScore().orElse(0),
				game.getTurn(),
				"You have died."
		);
	}
	
	@Transactional
	public ItemPurchase buyItem(String gameId,String itemId) {
		if(isItemAlreadyBought(gameId, itemId)) {
			throw new BadRequestException("Item '" + itemId 
					+ "' is is already purchaced in game '" 
					+ gameId + "'"
			);
		}
		Game game = gameRepository.findById(gameId).get();
		Item item = itemrepository.findById(itemId).get();
		game.setTurn(game.getTurn() + 1);
		if(game.getGold() < item.getGold()) {
			return failBuyItem(game, item);
		}
		game.setGold(game.getGold() - item.getGold());
		BoughtItem boughtItem = new BoughtItem();
		boughtItem.setItem(item);;
		boughtItem.setGame(game);
		boughtItemRepository.save(boughtItem);
		
		return new ItemPurchase(
				"true",
				game.getGold(), 
				game.getLives(), 
				gameRepository.findGameLevel(gameId),
				game.getTurn()
		);
	}
	
	private ItemPurchase failBuyItem(Game game,Item item) {
		gameRepository.save(game);
		return new ItemPurchase(
				"false",
				game.getGold(), 
				game.getLives(), 
				gameRepository.findGameLevel(game.getId()),
				game.getTurn()
		);
	}
	
	public boolean isAdAlreadyCompleted(String gameId,String adId) {
		return completedAdRepository.existsById(new CompletedAdId(gameId, adId));
	}
	
	public boolean isItemAlreadyBought(String gameId,String itemId) {
		return boughtItemRepository.existsById(new BoughtItemId(gameId, itemId));
	}
	
}
