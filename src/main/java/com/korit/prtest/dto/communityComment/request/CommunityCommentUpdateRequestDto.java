package com.korit.prtest.dto.communityComment.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityCommentUpdateRequestDto {

    @NotBlank(message = "댓글 내용은 필수 입력 값입니다.")
    @Size(max = 500, message = "댓글 내용은 최대 500자까지 입력 가능합니다.")
    private String content;
}
