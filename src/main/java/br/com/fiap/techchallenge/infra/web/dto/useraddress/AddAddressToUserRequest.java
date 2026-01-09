package br.com.fiap.techchallenge.infra.web.dto.useraddress;

public record AddAddressToUserRequest(
        String addressId,
        String addressType,
        String label
) {
}
