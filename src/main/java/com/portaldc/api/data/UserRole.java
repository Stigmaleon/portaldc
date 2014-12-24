package com.portaldc.api.data;

public enum UserRole {
    ADMIN("A"),
    MODERATOR("M"),
    USER("U");

    private final String userRoleLabel;

    UserRole(String userRoleLabel) {
        this.userRoleLabel = userRoleLabel;
    }

    public String getUserRole() {
        return userRoleLabel;
    }
}
