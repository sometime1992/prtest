package com.korit.prtest.repository;

import com.korit.prtest.entity.CommunityComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityCommentRepository extends JpaRepository<CommunityComments, Long> {
}
