package br.com.organization.organize.application.dto.user;

public record UserResponse(
        String name,
        String email,
        String password
) {
}
