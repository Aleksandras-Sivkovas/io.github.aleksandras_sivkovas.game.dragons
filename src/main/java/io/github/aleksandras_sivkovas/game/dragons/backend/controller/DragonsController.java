package io.github.aleksandras_sivkovas.game.dragons.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.aleksandras_sivkovas.game.dragons.backend.dto.AdDTO;
import io.github.aleksandras_sivkovas.game.dragons.backend.dto.GameDTO;
import io.github.aleksandras_sivkovas.game.dragons.backend.dto.InvestigationReputation;
import io.github.aleksandras_sivkovas.game.dragons.backend.dto.ItemDTO;
import io.github.aleksandras_sivkovas.game.dragons.backend.dto.ItemPurchase;
import io.github.aleksandras_sivkovas.game.dragons.backend.dto.TaskSolveResult;
import io.github.aleksandras_sivkovas.game.dragons.backend.repository.AdRepository;
import io.github.aleksandras_sivkovas.game.dragons.backend.repository.GameRepository;
import io.github.aleksandras_sivkovas.game.dragons.backend.repository.ItemRepository;
import io.github.aleksandras_sivkovas.game.dragons.backend.service.DragonsService;

@RequestMapping("/api/v2/")
@RestController
public class DragonsController {
	
	@Autowired
    private DragonsService dragonsService;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private AdRepository adRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
    @RequestMapping(value = "/game/{gameId:[\\d]+}", method = RequestMethod.GET)
    public GameDTO getGame(@PathVariable String gameId) {
    	return gameRepository.findGameDTO(gameId);
    }
    
    @RequestMapping(value = "/game/start", method = RequestMethod.POST)
    public GameDTO getNewGame() {
    	String gameId = dragonsService.createNewGame();
    	return this.getGame(gameId);
    }
    
    @RequestMapping(value = "/{gameId}/investigate/reputation", method = RequestMethod.GET)
    public InvestigationReputation getReputationInvestigetion(@PathVariable String gameId) {
    	return gameRepository.findReputationInvestigetion(gameId);
    }
    
    @RequestMapping(value = "/{gameId}/messages", method = RequestMethod.GET)
    public List<AdDTO> getMessages(
    		@PathVariable String gameId,
    		@RequestParam(defaultValue = "0" ) int page,
    		@RequestParam(defaultValue = "100") int size) {
    	return adRepository.findNotCompletedAdsByGame(gameId, PageRequest.of(page, size));
    }
    
    @RequestMapping(value = "/{gameId}/solve/{adId}", method = RequestMethod.POST)
    public TaskSolveResult getMessageSolved(
    		@PathVariable(required = true) String gameId,
    		@PathVariable(required = true) String adId
    ) {
    	return dragonsService.solveAd(gameId, adId);
    }
    
    @RequestMapping(value = "/{gameId}/shop", method = RequestMethod.GET)
    public List<ItemDTO> getItemsInShop(
    		@PathVariable(required = true) String gameId,
    		@RequestParam(defaultValue = "0" ) int page,
    		@RequestParam(defaultValue = "100") int size
    ) {
    	return itemRepository.findNotBoughtItemsByGame(gameId, PageRequest.of(page, size));
    }
    
    @RequestMapping(value = "/{gameId}/shop/buy/{itemId}", method = RequestMethod.POST)
    public ItemPurchase getItemBought(
    		@PathVariable(required = true) String gameId,
    		@PathVariable(required = true) String itemId
    ) {
    	return dragonsService.buyItem(gameId, itemId);
	    
    }
}
