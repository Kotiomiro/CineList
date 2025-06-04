package com.cinelist.cinelist_api.repository;

import com.cinelist.cinelist_api.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {

    public Comment findCommentById(UUID id);
}
