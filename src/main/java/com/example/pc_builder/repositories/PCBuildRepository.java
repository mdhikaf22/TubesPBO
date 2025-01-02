package com.example.pc_builder.repositories;

import com.example.pc_builder.models.PCBuild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PCBuildRepository extends JpaRepository<PCBuild, Long> {
    List<PCBuild> findByTotalPrice(Double totalPrice);

    @Query("SELECT b FROM PCBuild b WHERE b.totalPrice BETWEEN :minBudget AND :maxBudget")
    List<PCBuild> findBuildsWithinBudget(Double minBudget, Double maxBudget);
}
