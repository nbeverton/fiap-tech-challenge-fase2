package br.com.fiap.techchallenge.G13.TechChallenge2.G13.infra.web.dto.user;

import br.com.fiap.techchallenge.G13.TechChallenge2.G13.core.domain.enums.UserType;

public record CreateUserRequest (
        String name,
        UserType type,
        String email,
        String login,
        String password
){}
