package com.gmail.alexey375890.enums;

public enum Permission {
    DEVELOPERS_SAVE("Post"),
    DEVELOPERS_GET("Get"),
    DEVELOPERS_UPDATE("Put"),
    DEVELOPERS_DELETE("Delete");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
