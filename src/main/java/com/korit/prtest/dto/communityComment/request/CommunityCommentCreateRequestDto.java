package com.korit.prtest.dto.communityComment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityCommentCreateRequestDto {
    private Long communityId; // 댓글이 달릴 커뮤니티 게시글의 ID
    private String content;   // 댓글 내용
    private Long parentCommentId; // 원댓글 여부 (true: 원댓글, false: 대댓글)


}
