package com.korit.prtest.dto.auth.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDto {
   private com.korit.prtest.entity.User user;
   private String token;
   private int exprTime;

}
