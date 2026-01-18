package br.com.fiap.techchallenge.infra.web.dto.useraddress;

import io.swagger.v3.oas.annotations.media.Schema;

public record AddAddressToUserRequest(
        @Schema(example = "6961450e9eb127678665c6f5")
        String addressId,
        @Schema(example = "HOME")
        String addressType,
        @Schema(example = "Minha casa")
        String label
) {
}
/*
{
    "addressId": "6961450e9eb127678665c6f5",
    "addressType": "HOME",
    "label": "Minha casa"
}
 */