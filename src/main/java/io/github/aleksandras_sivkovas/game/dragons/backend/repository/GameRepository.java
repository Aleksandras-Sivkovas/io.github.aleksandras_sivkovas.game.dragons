package io.github.aleksandras_sivkovas.game.dragons.backend.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.aleksandras_sivkovas.game.dragons.backend.data.Game;
import io.github.aleksandras_sivkovas.game.dragons.backend.dto.GameDTO;
import io.github.aleksandras_sivkovas.game.dragons.backend.dto.InvestigationReputation;

public interface GameRepository extends JpaRepository<Game,String>, GameRepositoryCustom {
	@Query(
		"SELECT new io.github.aleksandras_sivkovas.game.dragons.backend.dto.GameDTO("
			+ "g.id,"
			+ "g.lives,"
			+ "g.gold,"
			+"(SELECT "
			+ "sum(i.ability)"
			+ "FROM Game g1 "
			+ "JOIN g1.boughtItems bi "
			+ "JOIN bi.item i "
			+ "WHERE g1.id = :gameId"
			+ "),"
			+ "g.score,"
			+ "(select max(score) from Game),"
			+ "g.turn"
			+ ") FROM Game g "
			+ "WHERE g.id = :gameId"
	)
	public GameDTO findGameDTO(@Param("gameId") String gameId);
	
	@Query(
			"SELECT new io.github.aleksandras_sivkovas.game.dragons.backend.dto.InvestigationReputation("
			+ "(SELECT count(*) + 1 FROM Game g WHERE g.score > (SELECT g1.score FROM Game g1 WHERE g1.id = :gameId)),"
			+ "(SELECT count(*) + 1 FROM Game g WHERE g.score > (SELECT g1.score FROM Game g1 WHERE g1.id = :gameId)),"
			+ "(SELECT count(*) + 1 FROM Game g WHERE g.score > (SELECT g1.score FROM Game g1 WHERE g1.id = :gameId))"
			+ ") FROM Game WHERE id = :gameId"
	)
	public InvestigationReputation findReputationInvestigetion(@Param("gameId") String gameId);
	
	
	@Query("select max(score) from Game")
	public Optional<Integer> findHighScore();
}
