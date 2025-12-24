package br.com.fiap.techchallenge.infra.web.dto.user;

public record UserResponse(
        String id,
        String name,
        String type,
        String email,
        String login
) {
}
