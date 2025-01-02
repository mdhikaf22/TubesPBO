package com.example.pc_builder.dto;

import com.example.pc_builder.models.User;
import lombok.Data;

@Data
public class ForumCommentDTO {
    private String comment;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCopiedBuild() {
        return copiedBuild;
    }

    public void setCopiedBuild(String copiedBuild) {
        this.copiedBuild = copiedBuild;
    }

    private String createdAt;
    private String userName;
    private User user;
    private String copiedBuild;
}
