package com.korit.prtest.dto.coummunity.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommunityUpdateRequestDto {

    @NotNull
    private Long communityId;

    @NotNull
    private Long Id;

    @NotBlank
    private String communityTitle;

    @NotBlank
    private String communityContent;

}
