package com.korit.prtest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COMMUNITY_COMMENTS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"community", "user", "parent", "children"})
@EqualsAndHashCode(exclude = {"community", "user", "parent", "children"})
public class CommunityComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMUNITY_COMMENTS_ID", nullable = false, updatable = false)
    private Long communityCommentsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMUNITY_ID", nullable = false)
    private Community community; // Community 엔티티 참조

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", nullable = false)
    private User user; // User 엔티티 참조

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_COMMENT_ID")
    private CommunityComments parent; // 부모 댓글 참조

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommunityComments> children = new ArrayList<>(); // 자식 댓글 목록

    @Column(name = "COMMUNITY_COMMENTS_CONTENTS", nullable = false, columnDefinition = "TEXT")
    private String communityCommentsContents; // 댓글 내용
}
