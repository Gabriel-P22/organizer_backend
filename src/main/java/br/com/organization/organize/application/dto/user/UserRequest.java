package br.com.organization.organize.application.dto.user;

public record UserRequest(
        String name,
        String email,
        String password
) {
}
