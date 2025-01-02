package com.example.pc_builder.controller;

import com.example.pc_builder.dto.ForumCommentDTO;
import com.example.pc_builder.models.Forum;
import com.example.pc_builder.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forums")
public class ForumController {

    @Autowired
    private ForumService forumService;

    // Create a new comment
    @PostMapping
    public ResponseEntity<Forum> createComment(@RequestBody Forum forum) {
        Forum createdForum = forumService.createComment(forum);
        return ResponseEntity.ok(createdForum);
    }

    // Get a comment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Forum> getCommentById(@PathVariable Long id) {
        return forumService.getCommentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all comments
    @GetMapping
    public ResponseEntity<List<Forum>> getAllComments() {
        return ResponseEntity.ok(forumService.getAllComments());
    }

    // Get all comments by PC Build ID
    @GetMapping("/pc-build/{pcBuildId}")
    public ResponseEntity<List<ForumCommentDTO>> getCommentsByPCBuildId(@PathVariable Long pcBuildId) {
        try {
            List<ForumCommentDTO> comments = forumService.getCommentsByPCBuildId(pcBuildId);
            return ResponseEntity.ok(comments);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Update a comment
    @PutMapping("/{id}")
    public ResponseEntity<Forum> updateComment(@PathVariable Long id, @RequestBody Forum updatedForum) {
        try {
            Forum updated = forumService.updateComment(id, updatedForum);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a comment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        try {
            forumService.deleteComment(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
