package br.com.fiap.techchallenge.infra.web.dto.user;

public record CreateUserRequest (
        String name,
        String type,
        String email,
        String login,
        String password
){
}
