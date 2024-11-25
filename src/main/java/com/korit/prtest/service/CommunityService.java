package com.korit.prtest.service;

import com.korit.prtest.dto.ResponseDto;
import com.korit.prtest.dto.coummunity.request.CommunityCreateRequestDto;
import com.korit.prtest.dto.coummunity.response.CommunityResponseDto;

import java.util.List;

public interface CommunityService {
    ResponseDto<CommunityResponseDto> createCommunity(Long authorId, CommunityCreateRequestDto dto);
    ResponseDto<CommunityResponseDto> updateCommunity(Long authorId, Long id, CommunityCreateRequestDto dto);
    ResponseDto<Void> deleteCommunity(Long authorId, Long id);
    ResponseDto<List<CommunityResponseDto>> getAllCommunities();
    ResponseDto<CommunityResponseDto> getCommunity(Long id);
    ResponseDto<CommunityResponseDto> getEditableCommunity(Long authorId, Long id);
}
