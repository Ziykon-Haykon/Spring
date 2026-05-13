package com.takamori.spring.repository;

import com.takamori.spring.entity.CalcHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalcHistoryRepository extends JpaRepository<CalcHistory, Long> {
}
