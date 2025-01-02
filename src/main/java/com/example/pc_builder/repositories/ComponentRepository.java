package com.example.pc_builder.repositories;

import com.example.pc_builder.models.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Long> {
}
