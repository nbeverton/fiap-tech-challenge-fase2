package br.com.fiap.techchallenge.core.usecase.out;

import br.com.fiap.techchallenge.core.domain.enums.AddressType;

public record UserAddressSummaryOutput(
        AddressType addressType,
        String streetName,
        int streetNumber,
        String neighborhood,
        String city,
        String stateProvince,
        String additionalInfo,
        boolean principal
) {
}
