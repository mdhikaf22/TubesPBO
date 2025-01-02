package com.example.pc_builder.repositories;

import com.example.pc_builder.models.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForumRepository extends JpaRepository<Forum, Long> {
    List<Forum> findByPcBuild_BuildId(Long buildId);
}
