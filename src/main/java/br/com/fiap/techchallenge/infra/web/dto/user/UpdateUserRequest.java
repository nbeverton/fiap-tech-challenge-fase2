package br.com.fiap.techchallenge.infra.web.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

public record UpdateUserRequest(
        @Schema(example = "Usuário Tech (edit)")
        String name,
        @Schema(example = "userTech.tech@example.com")
        String email,
        @Schema(example = "user.techChallenge (edit)")
        String login,
        @Schema(example = "SenhaForte123!")
        String password
) {}
/*
{
  "name": "Usuário Tech (edit)",
  "email": "userTech.tech@example.com",
  "login": "user.techChallenge (edit)",
  "password": "SenhaForte123!"
}
 */
