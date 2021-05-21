package com.segagames.Sega_Rest_api.repository;

import com.segagames.Sega_Rest_api.entity.GameTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameTransactionRepository extends JpaRepository<GameTransaction,Integer> {
}
