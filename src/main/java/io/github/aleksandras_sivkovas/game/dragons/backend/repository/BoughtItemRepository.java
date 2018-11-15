package io.github.aleksandras_sivkovas.game.dragons.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.aleksandras_sivkovas.game.dragons.backend.data.BoughtItem;
import io.github.aleksandras_sivkovas.game.dragons.backend.data.BoughtItemId;

public interface BoughtItemRepository extends JpaRepository<BoughtItem,BoughtItemId> {

}