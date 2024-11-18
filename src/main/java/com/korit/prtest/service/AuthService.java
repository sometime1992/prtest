package com.korit.prtest.service;

import com.korit.prtest.dto.ResponseDto;
import com.korit.prtest.dto.auth.reponse.LoginResponseDto;
import com.korit.prtest.dto.auth.reponse.SignUpResponseDto;
import com.korit.prtest.dto.auth.request.LoginRequestDto;
import com.korit.prtest.dto.auth.request.SignUpRequestDto;

public interface AuthService {

    ResponseDto<SignUpResponseDto> singUp(SignUpRequestDto dto);
    ResponseDto<LoginResponseDto> login(LoginRequestDto dto);

}
