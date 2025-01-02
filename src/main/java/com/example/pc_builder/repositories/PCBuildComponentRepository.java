package com.example.pc_builder.repositories;

import com.example.pc_builder.models.PCBuildComponent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PCBuildComponentRepository extends JpaRepository<PCBuildComponent, Long> {
}
