package br.com.fiap.techchallenge.infra.web.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateUserRequest(
        @Schema(example = "Usuário Tech Challenge")
        String name,
        @Schema(example = "OWNER")
        String userType,
        @Schema(example = "userTech.tech@example.com")
        String email,
        @Schema(example = "user.techChallenge")
        String login,
        @Schema(example = "SenhaForte123!")
        String password,
        @Schema(example = "696bd84bfd776b70fe1a4f89")
        String addressId,
        @Schema(example = "HOME")
        String addressType,
        @Schema(example = "casa")
        String label
) {
}
/*
{
  "name": "Usuário Tech Challenge",
  "userType": "OWNER",
  "email": "userTech.tech@example.com",
  "login": "user.techChallenge",
  "password": "SenhaForte123!",
  "addressId": "{{addressId}}",
  "addressType": "HOME",
  "label": "casa"
}
 */