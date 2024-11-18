package com.korit.prtest.dto.coummunity.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class CommunityCreateRequestDto {

    @NotBlank
    private String communityTitle;

    @NotBlank
    private String communityContent;

    private String communityThumbnailImgUrl;

    private List<CommunityAttachmentRequestDto> communityAttachments;


}

