package br.com.fiap.techchallenge.infra.web.dto.useraddress;

import io.swagger.v3.oas.annotations.media.Schema;

public record UpdateUserAddressRequest(
        @Schema(example = "OTHER")
        String type,
        @Schema(example = "Parque")
        String label,
        @Schema(example = "true")
        boolean principal
) {
}
/*
{
  "type": "OTHER",
  "label": "Parque",
  "principal": true
}
 */