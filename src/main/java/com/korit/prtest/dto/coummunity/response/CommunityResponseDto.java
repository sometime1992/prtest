package com.korit.prtest.dto.coummunity.response;

import com.korit.prtest.dto.communityComment.response.CommunityCommentResponseDto;
import com.korit.prtest.entity.Community;
import com.korit.prtest.entity.CommunityAttachments;
import com.korit.prtest.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class CommunityResponseDto {

    private User userId;
    private String communityTitle;
    private int communityLikeCount = 0;
    private LocalDateTime communityCreatedAt;
    private LocalDateTime communityUpdatedAt;
    private String communityContent;
    private String communityThumbnailImageUrl;

    private List<CommunityAttachments> attachments;
    private List<CommunityCommentResponseDto> comments;

    public CommunityResponseDto(Community community) {
        this.userId = getUserId();
        this.communityTitle = community.getCommunityTitle();
        this.communityLikeCount = community.getCommunityLikeCount();
        this.communityCreatedAt = community.getCommunityCreatedAt();
        this.communityUpdatedAt = community.getCommunityUpdatedAt();
        this.communityContent = community.getCommunityContent();
        this.communityThumbnailImageUrl = community.getCommunityThumbnailImageUrl();
    }

}
