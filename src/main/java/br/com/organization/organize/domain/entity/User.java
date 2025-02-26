package br.com.organization.organize.domain.entity;

public record User(
        String name,
        String email,
        String password
) {
}
