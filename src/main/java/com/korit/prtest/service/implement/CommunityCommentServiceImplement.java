package com.korit.prtest.service.implement;

import com.korit.prtest.common.ResponseMessage;
import com.korit.prtest.dto.ResponseDto;
import com.korit.prtest.dto.communityComment.request.CommunityCommentCreateRequestDto;
import com.korit.prtest.dto.communityComment.request.CommunityCommentUpdateRequestDto;
import com.korit.prtest.dto.communityComment.response.CommunityCommentResponseDto;
import com.korit.prtest.entity.Community;
import com.korit.prtest.entity.CommunityComments;
import com.korit.prtest.entity.User;
import com.korit.prtest.repository.CommunityCommentRepository;
import com.korit.prtest.repository.CommunityRepository;
import com.korit.prtest.repository.UserRepository;
import com.korit.prtest.service.CommunityCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommunityCommentServiceImplement implements CommunityCommentService {

    private final CommunityCommentRepository communityCommentRepository;
    private final CommunityRepository communityRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public ResponseDto<CommunityCommentResponseDto> createComment(Long authorId, CommunityCommentCreateRequestDto dto) {
        try {
            User user = userRepository.findById(authorId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_USER));

            Community community = communityRepository.findById(dto.getCommunityId())
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_POST));

            CommunityComments parent = null;
            if (dto.getParentCommentId() != null) {
                parent = communityCommentRepository.findById(dto.getParentCommentId())
                        .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_COMMENT));
            }

            CommunityComments newComment = CommunityComments.builder()
                    .user(user)
                    .community(community)
                    .parent(parent)
                    .communityCommentsContents(dto.getContent())
                    .build();

            CommunityComments savedComment = communityCommentRepository.save(newComment);
            CommunityCommentResponseDto data = new CommunityCommentResponseDto(savedComment);

            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    @Transactional
    public ResponseDto<CommunityCommentResponseDto> updateComment(Long authorId, Long commentId, CommunityCommentUpdateRequestDto dto) {
        try {
            CommunityComments existingComment = communityCommentRepository.findById(commentId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_COMMENT));

            if (!existingComment.getUser().getId().equals(authorId)) {
                return ResponseDto.setFailed(ResponseMessage.NOT_AUTHOR);
            }

            existingComment.setCommunityCommentsContents(dto.getContent());
            CommunityComments updatedComment = communityCommentRepository.save(existingComment);
            CommunityCommentResponseDto data = new CommunityCommentResponseDto(updatedComment);

            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    @Transactional
    public ResponseDto<Void> deleteComment(Long authorId, Long commentId) {
        try {
            CommunityComments existingComment = communityCommentRepository.findById(commentId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_COMMENT));

            if (!existingComment.getUser().getId().equals(authorId)) {
                return ResponseDto.setFailed(ResponseMessage.NOT_AUTHOR);
            }

            communityCommentRepository.delete(existingComment);
            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseDto<List<CommunityCommentResponseDto>> getCommentsByCommunity(Long communityId) {
        try {
            List<CommunityComments> comments = communityCommentRepository.findByCommunity_CommunityId(communityId);

            List<CommunityCommentResponseDto> data = comments.stream()
                    .map(CommunityCommentResponseDto::new)
                    .collect(Collectors.toList());

            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseDto<CommunityCommentResponseDto> getCommentById(Long commentId) {
        try {
            CommunityComments comment = communityCommentRepository.findById(commentId)
                    .orElseThrow(() -> new IllegalArgumentException(ResponseMessage.NOT_EXIST_COMMENT));

            CommunityCommentResponseDto data = new CommunityCommentResponseDto(comment);
            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }
}
