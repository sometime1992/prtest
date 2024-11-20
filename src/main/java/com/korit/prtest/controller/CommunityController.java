package com.korit.prtest.controller;

import com.korit.prtest.common.ApiMappingPattern;
import com.korit.prtest.dto.ResponseDto;
import com.korit.prtest.dto.coummunity.request.CommunityCreateRequestDto;
import com.korit.prtest.dto.coummunity.response.CommunityResponseDto;
import com.korit.prtest.service.CommunityService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.korit.prtest.common.ApiMappingPattern.*;

@RestController
@RequestMapping(ApiMappingPattern.COMMUNITY)
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    /**
     * 커뮤니티 게시글 생성
     * @param userId - 작성자 ID (인증 정보에서 가져옴)
     * @param dto - 생성 요청 데이터 (제목, 내용, 첨부파일 등)
     * @return 생성된 커뮤니티 게시글 정보
     */
    @PostMapping
    public ResponseEntity<ResponseDto<CommunityResponseDto>> createCommunity(
            @AuthenticationPrincipal String userId,
            @RequestBody CommunityCreateRequestDto dto
    ) {
        Long authorId = Long.parseLong(userId);
        ResponseDto<CommunityResponseDto> response = communityService.createCommunity(authorId, dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    /**
     * 커뮤니티 게시글 수정
     * @param userId - 작성자 ID (인증 정보에서 가져옴)
     * @param id - 수정할 게시글 ID
     * @param dto - 수정 요청 데이터 (제목, 내용, 첨부파일 등)
     * @return 수정된 커뮤니티 게시글 정보
     */
    @PutMapping(COMMUNITY_PUT)
    public ResponseEntity<ResponseDto<CommunityResponseDto>> updateCommunity(
            @AuthenticationPrincipal String userId,
            @PathVariable Long id,
            @RequestBody CommunityCreateRequestDto dto
    ) {
        Long authorId = Long.parseLong(userId);
        ResponseDto<CommunityResponseDto> response = communityService.updateCommunity(authorId, id, dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    /**
     * 커뮤니티 게시글 삭제
     * @param userId - 작성자 ID (인증 정보에서 가져옴)
     * @param id - 삭제할 게시글 ID
     * @return 삭제 성공 여부
     */
    @DeleteMapping(COMMUNITY_DELETE)
    public ResponseEntity<ResponseDto<Void>> deleteCommunity(
            @AuthenticationPrincipal String userId,
            @PathVariable Long id
    ) {
        Long authorId = Long.parseLong(userId);
        ResponseDto<Void> response = communityService.deleteCommunity(authorId, id);
        HttpStatus status = response.isResult() ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    /**
     * 모든 커뮤니티 게시글 조회
     * @return 모든 커뮤니티 게시글 정보 리스트
     */
    @GetMapping
    @PermitAll
    public ResponseEntity<ResponseDto<List<CommunityResponseDto>>> getAllCommunities() {
        ResponseDto<List<CommunityResponseDto>> response = communityService.getAllCommunities();
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        return ResponseEntity.status(status).body(response);
    }

    /**
     * 특정 커뮤니티 게시글 조회
     * @param id - 조회할 게시글 ID
     * @return 해당 게시글 정보
     */
    @GetMapping(COMMUNITY_GET_BY_ID)
    @PermitAll
    public ResponseEntity<ResponseDto<CommunityResponseDto>> getCommunity(@PathVariable Long id) {
        ResponseDto<CommunityResponseDto> response = communityService.getCommunity(id);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }

    /**
     * 수정 가능한 커뮤니티 게시글 조회
     * @param userId - 작성자 ID (인증 정보에서 가져옴)
     * @param id - 조회할 게시글 ID
     * @return 수정 가능한 게시글 정보
     */
    @GetMapping(COMMUNITY_ET_EDITABLE_BY_ID)
    public ResponseEntity<ResponseDto<CommunityResponseDto>> getEditableCommunity(
            @AuthenticationPrincipal String userId,
            @PathVariable Long id
    ) {
        Long authorId = Long.parseLong(userId);
        ResponseDto<CommunityResponseDto> response = communityService.getEditableCommunity(authorId, id);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }
}
