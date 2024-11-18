package com.korit.prtest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String userName;

    @Column(name = "USER_ID", nullable = false, unique = true)
    private String userId;

    @Column(name = "USER_PASSWORD",nullable = false)
    private String userPassword;

    @Column(name = "USER_NICK_NAME", nullable = false, unique = true)
    private String userNickName;

    @Column(name = "USER_PHONE", nullable = false, unique = true)
    private String userPhone;

    @Column(name = "USER_ADDRESS", nullable = false)
    private String userAddress;

    @Column(name = "USER_ADDRESS_DETAIL", nullable = false)
    private String userAddressDetail;

    @Column(name = "USER_EMAIL", nullable = false, unique = true)
    private String userEmail;

    @Column(name = "USER_PROFILE_IMAGE_URL")
    private String userProfileImageUrl;

    @OneToMany(mappedBy = "author")
    private List<Community> posts = new ArrayList<>();

    @OneToMany(mappedBy = "author")
    private List<CommunityComments> comments = new ArrayList<>();

}
