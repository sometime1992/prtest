package com.korit.prtest.controller;

import com.korit.prtest.common.ApiMappingPattern;
import com.korit.prtest.dto.ResponseDto;
import com.korit.prtest.dto.communityComment.request.CommunityCommentCreateRequestDto;
import com.korit.prtest.dto.communityComment.request.CommunityCommentUpdateRequestDto;
import com.korit.prtest.dto.communityComment.response.CommunityCommentResponseDto;
import com.korit.prtest.service.CommunityCommentService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiMappingPattern.COMMUNITY_COMMENT)
@RequiredArgsConstructor
public class CommunityCommentController {

    private final CommunityCommentService communityCommentService;

    /**
     * 댓글 생성
     * @param userId - 댓글 작성자의 ID (인증 정보에서 가져옴)
     * @param dto - 댓글 생성 요청 데이터 (내용, 커뮤니티 ID, 부모 댓글 ID 등)
     * @return 생성된 댓글의 정보
     */
    @PostMapping
    public ResponseEntity<ResponseDto<CommunityCommentResponseDto>> createComment(
            @AuthenticationPrincipal String userId,
            @RequestBody CommunityCommentCreateRequestDto dto
    ) {
        Long authorId = Long.parseLong(userId);
        ResponseDto<CommunityCommentResponseDto> response = communityCommentService.createComment(authorId, dto);
        HttpStatus status = response.isResult() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    /**
     * 댓글 수정
     * @param userId - 댓글 작성자의 ID (인증 정보에서 가져옴)
     * @param commentId - 수정할 댓글의 ID
     * @param dto - 댓글 수정 요청 데이터 (내용 수정)
     * @return 수정된 댓글의 정보
     */
    @PutMapping("/{commentId}")
    public ResponseEntity<ResponseDto<CommunityCommentResponseDto>> updateComment(
            @AuthenticationPrincipal String userId,
            @PathVariable Long commentId,
            @RequestBody CommunityCommentUpdateRequestDto dto
    ) {
        Long authorId = Long.parseLong(userId);
        ResponseDto<CommunityCommentResponseDto> response = communityCommentService.updateComment(authorId, commentId, dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    /**
     * 댓글 삭제
     * @param userId - 댓글 작성자의 ID (인증 정보에서 가져옴)
     * @param commentId - 삭제할 댓글의 ID
     * @return 삭제 성공 여부
     */
    @DeleteMapping("/{commentId}")
    public ResponseEntity<ResponseDto<Void>> deleteComment(
            @AuthenticationPrincipal String userId,
            @PathVariable Long commentId
    ) {
        Long authorId = Long.parseLong(userId);
        ResponseDto<Void> response = communityCommentService.deleteComment(authorId, commentId);
        HttpStatus status = response.isResult() ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    /**
     * 특정 커뮤니티의 모든 댓글 조회
     * @param communityId - 조회할 커뮤니티 ID
     * @return 해당 커뮤니티의 댓글 리스트
     */
    @GetMapping("/community/{communityId}")
    @PermitAll
    public ResponseEntity<ResponseDto<List<CommunityCommentResponseDto>>> getCommentsByCommunity(
            @PathVariable Long communityId
    ) {
        ResponseDto<List<CommunityCommentResponseDto>> response = communityCommentService.getCommentsByCommunity(communityId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        return ResponseEntity.status(status).body(response);
    }

    /**
     * 특정 댓글 조회
     * @param commentId - 조회할 댓글 ID
     * @return 해당 댓글의 정보
     */
    @GetMapping("/{commentId}")
    @PermitAll
    public ResponseEntity<ResponseDto<CommunityCommentResponseDto>> getCommentById(
            @PathVariable Long commentId
    ) {
        ResponseDto<CommunityCommentResponseDto> response = communityCommentService.getCommentById(commentId);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }
}
