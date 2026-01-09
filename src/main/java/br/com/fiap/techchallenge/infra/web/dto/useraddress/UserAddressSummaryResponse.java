package br.com.fiap.techchallenge.infra.web.dto.useraddress;

public record UserAddressSummaryResponse(
        String addressType,
        String streetName,
        int streetNumber,
        String neighborhood,
        String city,
        String stateProvince,
        String additionalInfo,
        boolean principal
) {
}
