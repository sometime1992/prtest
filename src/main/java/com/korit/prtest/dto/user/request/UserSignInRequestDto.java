package com.korit.prtest.dto.user.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignInRequestDto {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
