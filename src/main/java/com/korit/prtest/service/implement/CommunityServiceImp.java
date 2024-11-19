package com.korit.prtest.service.implement;

import com.korit.prtest.common.ResponseMessage;
import com.korit.prtest.dto.ResponseDto;
import com.korit.prtest.dto.coummunity.request.CommunityAttachmentRequestDto;
import com.korit.prtest.dto.coummunity.request.CommunityCreateRequestDto;
import com.korit.prtest.dto.coummunity.response.CommunityResponseDto;
import com.korit.prtest.entity.Community;
import com.korit.prtest.entity.CommunityAttachments;
import com.korit.prtest.repository.CommunityAttachmentRepository;
import com.korit.prtest.repository.CommunityRepository;
import com.korit.prtest.service.CommunityService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommunityServiceImp implements CommunityService {

    private final CommunityRepository communityRepository;
    private final CommunityAttachmentRepository communityAttachmentRepository;

    @Override
    public ResponseDto<CommunityResponseDto> createCommunity(Long authorId, CommunityCreateRequestDto dto) {
        CommunityResponseDto data = null;
        String title = dto.getCommunityTitle();
        String content = dto.getCommunityContent();
        List<CommunityAttachmentRequestDto> dtoa = dto.getCommunityAttachments();

        try {
            Community community = Community.builder()
                    .communityTitle(title)
                    .communityContent(content)
                    .communityThumbnailImageUrl(dto.getCommunityThumbnailImgUrl())
                    .build();

            Community savedCommunity = communityRepository.save(community);

            List<CommunityAttachments> attachments = dtoa.stream()
                    .map(attachmentDto -> {
                        CommunityAttachments attachment = CommunityAttachments.builder()
                                .community(savedCommunity)
                                .communityAttachmentImageUrl(attachmentDto.getCommAttachmentImageUrl())
                                .build();
                        return communityAttachmentRepository.save(attachment);
                    })
                    .toList();

            savedCommunity.setCommunityAttachments(attachments);
            communityRepository.save(savedCommunity);

            data = new CommunityResponseDto(savedCommunity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    @Override
    public ResponseDto<CommunityResponseDto> updateCommunity(Long authorId, Long id, CommunityCreateRequestDto dto) {
        CommunityResponseDto data = null;
        String title = dto.getCommunityTitle();
        String content = dto.getCommunityContent();
        List<CommunityAttachmentRequestDto> attachmentDtos = dto.getCommunityAttachments();

        try {
            Optional<Community> optionalCommunity = communityRepository.findById(id);

            if (optionalCommunity.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_POST);
            }

            Community community = optionalCommunity.get();

            community.setCommunityTitle(title);
            community.setCommunityContent(content);
            community.setCommunityThumbnailImageUrl(dto.getCommunityThumbnailImgUrl());

            communityAttachmentRepository.deleteByCommunity(community);

            List<CommunityAttachments> updatedAttachments = attachmentDtos.stream()
                    .map(attachmentDto -> {
                        CommunityAttachments attachment = CommunityAttachments.builder()
                                .community(community)
                                .communityAttachmentImageUrl(attachmentDto.getCommAttachmentImageUrl())
                                .build();
                        return communityAttachmentRepository.save(attachment);
                    })
                    .collect(Collectors.toList());

            community.setCommunityAttachments(updatedAttachments);

            Community updatedCommunity = communityRepository.save(community);

            data = new CommunityResponseDto(updatedCommunity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    @Override
    public ResponseDto<Void> deleteCommunity(Long authorId, Long id) {
        try {
            Optional<Community> optionalCommunity = communityRepository.findByCommunityIdAndAuthorId(authorId, id);

            if (optionalCommunity.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_POST);
            }

            Community community = optionalCommunity.get();

            communityAttachmentRepository.deleteByCommunity(community);

            communityRepository.delete(community);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, null);
    }

    @Override
    public ResponseDto<List<CommunityResponseDto>> getAllCommunities() {
        try {
            List<Community> communities = communityRepository.findAll();

            List<CommunityResponseDto> data = communities.stream()
                    .map(CommunityResponseDto::new)
                    .collect(Collectors.toList());

            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    @PermitAll
    public ResponseDto<CommunityResponseDto> getCommunity(Long id) {
        try {
            Optional<Community> optionalCommunity = communityRepository.findByIdWithCommentsAndAttachments(id);

            if (optionalCommunity.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_POST);
            }
            Community community = optionalCommunity.get();
            CommunityResponseDto data = new CommunityResponseDto(community);

            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    public ResponseDto<CommunityResponseDto> getEditableCommunity(Long authorId, Long id) {
        CommunityResponseDto data = null;

        try {
            Optional<Community> optionalCommunity = communityRepository.findByCommunityIdAndAuthorId(id, authorId);
            if (optionalCommunity.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_OR_NOT_AUTHOR);
            }
            Community community = optionalCommunity.get();
            data = new CommunityResponseDto(community);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

}
