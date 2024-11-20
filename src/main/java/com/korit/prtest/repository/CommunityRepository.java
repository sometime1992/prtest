package com.korit.prtest.repository;

import com.korit.prtest.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    // 특정 커뮤니티 ID와 작성자 ID로 커뮤니티 조회
    @Query("SELECT c FROM Community c WHERE c.communityId = :communityId AND c.user.id = :userId")
    Optional<Community> findByCommunityIdAndAuthorId(@Param("communityId") Long communityId, @Param("userId") Long userId);

    // 특정 ID로 커뮤니티 조회 시 댓글과 첨부파일을 함께 페치 조인
    @Query("SELECT c FROM Community c " +
            "LEFT JOIN FETCH c.communityComments " +
            "LEFT JOIN FETCH c.communityAttachments " +
            "WHERE c.communityId = :id")
    Optional<Community> findByIdWithCommentsAndAttachments(@Param("id") Long id);
}
