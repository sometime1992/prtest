package com.korit.prtest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "COMMUNITY_COMMENTS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMUNITY_COMMENTS_ID", nullable = false)
    private Long communityCommentsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMUNITY_ID", nullable = false)
    private Community community;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", nullable = false)
    private User user;

    @Column(name = "COMMUNITY_COMMENTS_PARENT_REPLY", nullable = false, length = 1)
    private char communityCommentsParentReply;

    @Column(name = "COMMUNITY_COMMENTS_CONTENTS", nullable = false, columnDefinition = "TEXT")
    private String communityCommentsContents;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}
