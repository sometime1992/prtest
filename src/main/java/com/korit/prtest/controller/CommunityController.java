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

    @GetMapping
    @PermitAll
    public ResponseEntity<ResponseDto<List<CommunityResponseDto>>> getAllCommunities() {
        ResponseDto<List<CommunityResponseDto>> response = communityService.getAllCommunities();
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        return ResponseEntity.status(status).body(response);
    }

    @GetMapping(COMMUNITY_GET_BY_ID)
    @PermitAll
    public ResponseEntity<ResponseDto<CommunityResponseDto>> getCommunity(@PathVariable Long id) {
        ResponseDto<CommunityResponseDto> response = communityService.getCommunity(id);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }
}
