package com.korit.prtest.common;

public class ResponseMessage {

    // 성공 및 일반 메시지
    public static final String SUCCESS = "Success"; // 성공 시 반환 메시지
    public static final String VALIDATION_FAIL = "Validation failed."; // 유효성 검사 실패 시 반환 메시지
    public static final String DATABASE_ERROR = "Database error."; // 데이터베이스 에러 시 반환 메시지

    // 사용자 이름 관련 메시지
    public static final String DUPLICATED_USER_NAME = "Duplicated user name."; // 사용자 이름 중복 시 반환 메시지
    public static final String INVALID_USER_NAME = "Invalid user name format."; // 유효하지 않은 사용자 이름 형식

    // 사용자 ID 관련 메시지
    public static final String INVALID_USER_ID = "Invalid user ID format."; // 유효하지 않은 사용자 ID 형식
    public static final String EXIST_USER_ID= "User already exists."; // 사용자가 이미 존재할 때 반환 메시지
    public static final String NOT_EXIST_USER_ID = "User does not exist."; // 사용자가 존재하지 않을 때 반환 메시지
    public static final String NOT_EXIST_OR_NOT_AUTHOR = "User does not exist or not author.";

    // 비밀번호 관련 메시지
    public static final String INVALID_USER_PASSWORD = "Invalid password format."; // 유효하지 않은 비밀번호 형식
    public static final String INVALID_CONFIRM_PASSWORD = "Password confirmation does not match."; // 비밀번호 확인이 일치하지 않을 때

    // 사용자 닉네임 관련 메시지
    public static final String EXIST_USER_NICKNAME = "User nickname already exists."; // 사용자의 닉네임이 이미 존재할 때 반환 메시지
    public static final String NOT_EXIST_USER_NICKNAME = "User nickname does not exist."; // 사용자가 닉네임이 존재하지 않을 때 반환 메시지
    public static final String INVALID_USER_NICKNAME = "Invalid user nickname format."; // 유효하지 않은 사용자 닉네임 형식

    // 사용자 이메일 관련 메시지
    public static final String EXIST_USER_EMAIL = "User email already exists."; // 사용자 이메일이 이미 존재할 때 반환 메시지
    public static final String NOT_EXIST_USER_EMAIL = "User email does not exist."; // 사용자 이메일이 존재하지 않을 때 반환 메시지
    public static final String INVALID_USER_EMAIL = "Invalid email format."; // 유효하지 않은 이메일 형식

    // 로그인 및 인증 관련 메시지
    public static final String SIGN_IN_FAIL = "Sign in failed."; // 로그인 실패 시 반환 메시지
    public static final String AUTHENTICATION_FAIL = "Authentication failed."; // 인증 실패 시 반환 메시지
    public static final String NOT_MATCH_USER_ID ="UserId does not match."; // 아이디 불일치 시 반환 메시지
    public static final String NOT_MATCH_PASSWORD = "Password does not match."; // 비밀번호 불일치 시 반환 메시지
    public static final String NO_PERMISSION = "No permission."; // 권한이 없을 때 반환 메시지

    // 사용자 휴대폰 관련 메시지
    public static final String INVALID_USER_PHONE = "Invalid user phone number format."; // 유효하지 않은 사용자 전화번호 형식
    public static final String EXIST_USER_PHONE = "Duplicated user phone number."; // 사용자 전화번호 중복 시 반환 메시지

    // 사용자 주소 관련 메시지
    public static final String INVALID_USER_ADDRESS = "Invalid user address format."; // 유효하지 않은 사용자 주소 형식
    public static final String INVALID_USER_ADDRESS_DETAIL = "Invalid user address detail format."; // 유효하지 않은 사용자 상세주소 형식

    // 사용자 프로필 관련 메시지
    public static final String INVALID_USER_PROFILE = "Invalid user profile format."; // 유효하지 않은 사용자 프로필 형식

    // 게시글 관련 메시지
    public static final String EXIST_POST = "Post already exists."; // 게시글이 이미 존재할 때 반환 메시지
    public static final String NOT_EXIST_POST = "Post does not exist."; // 게시글이 존재하지 않을 때 반환 메시지

    // 댓글 관련 메시지
    public static final String EXIST_COMMENT = "Comment already exists."; // 댓글이 이미 존재할 때 반환 메시지
    public static final String NOT_EXIST_COMMENT = "Comment does not exist."; // 댓글이 존재하지 않을 때 반환 메시지

    // 기타 메시지
    public static final String TOKEN_CREATE_FAIL = "Token creation failed."; // 토큰 생성 실패 시 반환 메시지
    public static final String MESSAGE_SEND_FAIL = "Failed to send authentication number."; // 인증 번호 전송 실패 시 반환 메시지
}
