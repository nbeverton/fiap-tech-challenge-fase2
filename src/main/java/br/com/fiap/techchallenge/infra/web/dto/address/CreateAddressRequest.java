package br.com.fiap.techchallenge.infra.web.dto.address;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateAddressRequest(
        @Schema(example = "00012-345")
        String postalCode,
        @Schema(example = "Av. Paulista")
        String streetName,
        @Schema(example = "123")
        int streetNumber,
        @Schema(example = "Sala 1")
        String additionalInfo,
        @Schema(example = "Centro")
        String neighborhood,
        @Schema(example = "São Paulo")
        String city,
        @Schema(example = "SP")
        String stateProvince,
        @Schema(example = "Brazil")
        String country
) {
}

/*
{
  "postalCode": "00012-345",
  "streetName": "Av. Paulista",
  "streetNumber": "123",
  "additionalInfo": "Sala 1",
  "neighborhood": "Centro",
  "city": "São Paulo",
  "stateProvince": "SP",
  "country": "Brazil"
}
 */