package com.korit.prtest.dto.communityComment.response;

import com.korit.prtest.entity.CommunityComments;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommunityCommentResponseDto {
    private Long commentId;        // 댓글 ID
    private Long communityId;      // 커뮤니티 게시글 ID
    private Long authorId;         // 댓글 작성자 ID
    private String commenter;      // 댓글 작성자 이름
    private String content;        // 댓글 내용
    private Long parentCommentId;  // 부모 댓글 ID (null이면 원댓글)
    private boolean isRootComment; // 원댓글 여부 (true: 원댓글, false: 대댓글)

    /**
     * CommunityComments 엔티티를 기반으로 DTO 생성
     * @param comment CommunityComments 엔티티
     */
    public CommunityCommentResponseDto(CommunityComments comment) {
        this.commentId = comment.getCommunityCommentsId();
        this.communityId = comment.getCommunity().getCommunityId();
        this.authorId = comment.getUser().getId();
        this.commenter = comment.getUser().getUserName();
        this.content = comment.getCommunityCommentsContents();
        this.parentCommentId = comment.getParent() != null ? comment.getParent().getCommunityCommentsId() : null;
        this.isRootComment = comment.getParent() == null;
    }
}
