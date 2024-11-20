package com.korit.prtest.repository;

import com.korit.prtest.entity.CommunityComments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityCommentRepository extends JpaRepository<CommunityComments, Long> {

    /**
     * 특정 커뮤니티에 속한 모든 댓글 조회
     */
    List<CommunityComments> findByCommunity_CommunityId(Long communityId);
}
