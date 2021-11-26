package com.gmail.alexey375890.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {

    GUEST(Set.of(
            Permission.DEVELOPERS_GET
    )),
    USER(Set.of(
            Permission.DEVELOPERS_SAVE,
            Permission.DEVELOPERS_GET,
            Permission.DEVELOPERS_UPDATE
    )),
    ADMIN(Set.of(
            Permission.DEVELOPERS_SAVE,
            Permission.DEVELOPERS_GET,
            Permission.DEVELOPERS_UPDATE,
            Permission.DEVELOPERS_DELETE
    ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
