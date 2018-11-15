package io.github.aleksandras_sivkovas.game.dragons.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.aleksandras_sivkovas.game.dragons.backend.data.Ad;
import io.github.aleksandras_sivkovas.game.dragons.backend.dto.AdDTO;

public interface AdRepository extends JpaRepository<Ad,String> {
	
	@Query(
			"SELECT new io.github.aleksandras_sivkovas.game.dragons.backend.dto.AdDTO("
			+ "a.id,"
			+ "a.message,"
			+ "a.reward,"
			+ "a.expireTurn" //TODO: expires in
			+ ") FROM Ad a "
			+ "JOIN a.completedAds ca "
			+ "WHERE ca.game.id = :gameId"
	)
	public List<AdDTO> findCompletedAdsByGame(@Param("gameId") String gameId);
	
	@Query(
			"SELECT new io.github.aleksandras_sivkovas.game.dragons.backend.dto.AdDTO("
			+ "a.id,"
			+ "a.message,"
			+ "a.reward,"
			+ "(1 + a.expireTurn - (SELECT g.turn FROM Game g WHERE g.id = :gameId))"
			+ ") FROM Ad a "
			+ "WHERE "
			+ "((SELECT g.turn FROM Game g WHERE g.id = :gameId) >= a.appearTurn) "
			+ "AND "
			+ "((SELECT g.turn FROM Game g WHERE g.id = :gameId) <= (a.expireTurn)) "
			+ "AND"
			+ "(a.id NOT IN "
			+ "(SELECT ca.ad.id FROM CompletedAd ca WHERE ca.game.id = :gameId))"
	)
	public List<AdDTO> findNotCompletedAdsByGame(@Param("gameId") String gameId,Pageable pageable);
	
	@Query(
			"SELECT a.difficulty "
			+ "FROM Ad a "
			+ "WHERE a.id = :adId"
	)
	public Optional<Integer> getAdDifficulty(@Param("adId") String adId);
	
}
