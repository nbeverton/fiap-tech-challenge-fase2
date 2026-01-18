package br.com.fiap.techchallenge.infra.web.dto.useraddress;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateUserAddressRequest(
        @Schema(example = "696bd84bfd776b70fe1a4f89")
        String userId,
        @Schema(example = "696bd84bfd776b70fe1a4f89")
        String addressId,
        @Schema(example = "HOME")
        String type,
        @Schema(example = "Casa")
        String label,
        @Schema(example = "true")
        boolean principal
) {
}
/*
{
  "userId": "{{userId}}",
  "addressId": "{{addressId}}",
  "type": "HOME",
  "label": "Casa",
  "principal": true
}
 */