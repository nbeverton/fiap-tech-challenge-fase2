package br.com.fiap.techchallenge.core.usecase.in.useraddress;

import br.com.fiap.techchallenge.core.domain.enums.AddressType;

public record AddAddressToUserInput(
        String userId,
        String addressId,
        AddressType addressType,
        String label
) {
}
