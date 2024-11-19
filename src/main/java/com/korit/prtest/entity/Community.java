package com.korit.prtest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COMMUNITIES")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMUNITY_ID", nullable = false, updatable = false)
    private Long communityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "COMMUNITY_TITLE", nullable = false)
    private String communityTitle;

    @Column(name = "COMMUNITY_LIKE_COUNT", nullable = false)
    private int communityLikeCount = 0;

    @Column(name = "COMMUNITY_CREATE_AT", nullable = false, updatable = false)
    private LocalDateTime communityCreatedAt;

    @Column(name = "COMMUNITY_UPDATE_AT")
    private LocalDateTime communityUpdatedAt;

    @Column(name = "COMMUNITY_CONTENTS", nullable = false, columnDefinition = "TEXT")
    private String communityContent;

    @Column(name = "COMMUNITY_THUMB_NAIL_IMG_URL")
    private String communityThumbnailImageUrl;

    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommunityComments> communityComments = new ArrayList<>();

    @OneToMany(mappedBy = "community", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommunityAttachments> communityAttachments = new ArrayList<>();
}
