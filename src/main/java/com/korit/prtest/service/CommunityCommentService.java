package com.korit.prtest.service;

import com.korit.prtest.dto.ResponseDto;
import com.korit.prtest.dto.communityComment.request.CommunityCommentCreateRequestDto;
import com.korit.prtest.dto.communityComment.request.CommunityCommentUpdateRequestDto;
import com.korit.prtest.dto.communityComment.response.CommunityCommentResponseDto;

import java.util.List;

public interface CommunityCommentService {

    /**
     * 댓글 생성
     *
     * @param authorId 작성자 ID
     * @param dto      댓글 생성 요청 DTO
     * @return 생성된 댓글의 응답 DTO를 포함한 ResponseDto
     */
    ResponseDto<CommunityCommentResponseDto> createComment(Long authorId, CommunityCommentCreateRequestDto dto);

    /**
     * 댓글 수정
     *
     * @param authorId  작성자 ID
     * @param commentId 댓글 ID
     * @param dto       댓글 수정 요청 DTO
     * @return 수정된 댓글의 응답 DTO를 포함한 ResponseDto
     */
    ResponseDto<CommunityCommentResponseDto> updateComment(Long authorId, Long commentId, CommunityCommentUpdateRequestDto dto);

    /**
     * 댓글 삭제
     *
     * @param authorId  작성자 ID
     * @param commentId 댓글 ID
     * @return 삭제 결과를 포함한 ResponseDto
     */
    ResponseDto<Void> deleteComment(Long authorId, Long commentId);

    /**
     * 특정 커뮤니티의 모든 댓글 조회
     *
     * @param communityId 커뮤니티 ID
     * @return 해당 커뮤니티의 댓글 목록을 포함한 ResponseDto
     */
    ResponseDto<List<CommunityCommentResponseDto>> getCommentsByCommunity(Long communityId);

    /**
     * 특정 댓글 조회
     *
     * @param commentId 댓글 ID
     * @return 해당 댓글의 응답 DTO를 포함한 ResponseDto
     */
    ResponseDto<CommunityCommentResponseDto> getCommentById(Long commentId);
}
