package br.com.fiap.techchallenge.infra.web.mapper.useraddress;

import br.com.fiap.techchallenge.core.domain.enums.AddressType;
import br.com.fiap.techchallenge.core.usecase.in.useraddress.AddAddressToUserInput;
import br.com.fiap.techchallenge.infra.web.dto.useraddress.AddAddressToUserRequest;

public class AddAddressToUserDtoMapper {

    private AddAddressToUserDtoMapper(){}


    public static AddAddressToUserInput toInput(
            String userId,
            AddAddressToUserRequest request
    ){
        return new AddAddressToUserInput(
                userId,
                request.addressId(),
                AddressType.valueOf(request.addressType()),
                request.label()
        );
    }
}
