package com.korit.prtest.dto.communityComment.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommunityCommentRequestDto {

    @NotNull
    private Long communityId;

    @NotNull
    private Long userId;

    @NotNull
    private Character communityCommentsParentReply;

    @NotBlank
    private String communityCommentsContent;
}
