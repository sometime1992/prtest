package com.korit.prtest.repository;

import com.korit.prtest.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    // 특정 커뮤니티 ID와 작성자 ID로 커뮤니티 조회
    @Query("SELECT c FROM Community c WHERE c.communityId = :communityId AND c.author.id = :authorId")
    Optional<Community> findByCommunityIdAndAuthorId(@Param("communityId") Long communityId, @Param("authorId") Long authorId);

    // 제목을 기준으로 검색 (부분 일치)
    List<Community> findByCommunityTitleContaining(String keyword);

    // 최신순으로 모든 커뮤니티 조회
    List<Community> findAllByOrderByCommunityCreatedAtDesc();

    // 특정 ID로 커뮤니티 조회 시 댓글과 첨부파일을 함께 페치 조인
    @Query("SELECT c FROM Community c " +
            "LEFT JOIN FETCH c.communityComments " +
            "LEFT JOIN FETCH c.communityAttachments " +
            "WHERE c.communityId = :id")
    Optional<Community> findByIdWithCommentsAndAttachments(@Param("id") Long id);
}
