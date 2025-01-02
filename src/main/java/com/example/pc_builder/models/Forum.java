package com.example.pc_builder.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Forum")
public class Forum {

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    public PCBuild getPcBuild() {
        return pcBuild;
    }

    public void setPcBuild(PCBuild pcBuild) {
        this.pcBuild = pcBuild;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCopiedBuild() {
        return copiedBuild;
    }

    public void setCopiedBuild(String copiedBuild) {
        this.copiedBuild = copiedBuild;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long forumId;

    @ManyToOne
    @JoinColumn(name = "build_id", nullable = false)
    private PCBuild pcBuild;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String createdAt;

    @Column(nullable = true)
    private String copiedBuild;
}
