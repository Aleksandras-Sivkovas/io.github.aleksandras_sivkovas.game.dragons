package io.github.aleksandras_sivkovas.game.dragons.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.aleksandras_sivkovas.game.dragons.backend.data.Item;
import io.github.aleksandras_sivkovas.game.dragons.backend.dto.ItemDTO;

public interface ItemRepository  extends JpaRepository<Item,String> {
	@Query(
			"SELECT new io.github.aleksandras_sivkovas.game.dragons.backend.dto.ItemDTO("
			+ "i.id,"
			+ "i.name,"
			+ "i.gold"
			+ ") FROM Item i "
			+ "WHERE "
			+ "i.id NOT IN "
			+ "(SELECT bi.item.id FROM BoughtItem bi WHERE bi.game.id = :gameId)"
	)
	public List<ItemDTO> findNotBoughtItemsByGame(@Param("gameId") String gameId,Pageable pageable);
	
	@Query(
		"SELECT sum(i.ability)"
		+ "FROM Game g1 "
		+ "JOIN g1.boughtItems bi "
		+ "JOIN bi.item i "
		+ "WHERE g1.id = :gameId"
	)
	public Optional<Integer> getBoughtItemsAbility(@Param("gameId") String gameId);
}
