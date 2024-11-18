package com.korit.prtest.dto.coummunity.request;

import lombok.Getter;

@Getter
public class CommunityAttachmentRequestDto {
    private Long communityAttachmentId;
    private Long communityId;
    private String commAttachmentImageUrl;
    private String commAttachmentCreateAt;

}
