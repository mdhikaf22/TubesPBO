package com.example.pc_builder.service;

import com.example.pc_builder.dto.ForumCommentDTO;
import com.example.pc_builder.models.Forum;
import com.example.pc_builder.repositories.ForumRepository;
import com.example.pc_builder.repositories.PCBuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ForumService {

    @Autowired
    private ForumRepository forumRepository;

    @Autowired
    private PCBuildRepository pcBuildRepository;

    // Create a new comment
    public Forum createComment(Forum forum) {
        return forumRepository.save(forum);
    }

    // Get a comment by ID
    public Optional<Forum> getCommentById(Long id) {
        return forumRepository.findById(id);
    }

    // Get all comments
    public List<Forum> getAllComments() {
        return forumRepository.findAll();
    }

    public List<ForumCommentDTO> getCommentsByPCBuildId(Long pcBuildId) {
        List<Forum> forums = forumRepository.findByPcBuild_BuildId(pcBuildId);

        List<ForumCommentDTO> forumCommentDTOs = new ArrayList<>();

        for (Forum forum : forums) {
            ForumCommentDTO dto = new ForumCommentDTO();
            dto.setComment(forum.getComment());
            dto.setCreatedAt(forum.getCreatedAt());
            dto.setCopiedBuild(forum.getCopiedBuild());

            // Assuming that the user has a `getName()` method to get the user's name
            if (forum.getUser() != null) {
                dto.setUserName(forum.getUser().getUsername());
            }

            dto.setUser(forum.getUser());

            forumCommentDTOs.add(dto);
        }
        return forumCommentDTOs;
    }


    // Update a comment
    public Forum updateComment(Long id, Forum updatedForum) {
        Optional<Forum> existingForum = forumRepository.findById(id);
        if (existingForum.isPresent()) {
            Forum forum = existingForum.get();
            forum.setComment(updatedForum.getComment());
            forum.setCreatedAt(updatedForum.getCreatedAt());
            return forumRepository.save(forum);
        } else {
            throw new RuntimeException("Comment not found for ID: " + id);
        }
    }

    // Delete a comment
    public void deleteComment(Long id) {
        forumRepository.deleteById(id);
    }
}
