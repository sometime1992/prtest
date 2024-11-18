package com.korit.prtest.dto.comment.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {
    private Long commentId;
    private Long communityId;
    private String content;
    private String commenter;
}
