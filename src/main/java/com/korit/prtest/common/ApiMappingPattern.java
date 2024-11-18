package com.korit.prtest.common;

public class ApiMappingPattern {
    public static final String AUTH = "/api/v1/auth";

    public static final String COMMUNITY = "/api/v1/users/community";
    public static final String COMMUNITY_PUT = "/{communityId}";
    public static final String COMMUNITY_DELETE = "/{communityId}";
    public static final String COMMUNITY_GET_BY_ID = "/{communityId}";

    public static final String USER = "/api/v1/users";
    public static final String ARTICLE = "/api/v1/articles";
    public static final String COMMENT = "/api/v1/commemts";
}
