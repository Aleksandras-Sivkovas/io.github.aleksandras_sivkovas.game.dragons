package io.github.aleksandras_sivkovas.game.dragons.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.aleksandras_sivkovas.game.dragons.backend.data.CompletedAd;
import io.github.aleksandras_sivkovas.game.dragons.backend.data.CompletedAdId;

public interface CompletedAdRepository extends JpaRepository<CompletedAd,CompletedAdId> {

}
