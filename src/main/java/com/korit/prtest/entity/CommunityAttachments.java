package com.korit.prtest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "COMMUNITY_ATTACHMENTS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityAttachments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMUNITY_ATTACHMENT_ID", nullable = false, updatable = false)
    private Long communityAttachmentId;

    @JoinColumn(name = "COMMUNITY_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Community community;

    @Column(name = "COMMUNITY_ATTACHMENT_IMAGE_URL")
    private String communityAttachmentImageUrl;

}
