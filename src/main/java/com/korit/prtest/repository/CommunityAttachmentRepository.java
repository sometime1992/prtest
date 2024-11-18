package com.korit.prtest.repository;

import com.korit.prtest.entity.Community;
import com.korit.prtest.entity.CommunityAttachments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityAttachmentRepository extends JpaRepository<CommunityAttachments, Long> {

    @Transactional
    void deleteByCommunity(Community community);
}
