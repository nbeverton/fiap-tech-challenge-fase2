package br.com.fiap.techchallenge.infra.web.mapper.user;

import br.com.fiap.techchallenge.core.domain.enums.AddressType;
import br.com.fiap.techchallenge.core.domain.enums.UserType;
import br.com.fiap.techchallenge.core.usecase.in.user.CreateUserWithAddressInput;
import br.com.fiap.techchallenge.infra.web.dto.user.CreateUserWithAddressRequest;

public class UserWithAddressDtoMapper {

    private UserWithAddressDtoMapper(){};


    public static CreateUserWithAddressInput toInput(CreateUserWithAddressRequest request){

        return new CreateUserWithAddressInput(
                request.name(),
                UserType.valueOf(request.userType()),
                request.email(),
                request.login(),
                request.password(),
                request.addressId(),
                AddressType.valueOf(request.addressType()),
                request.label()
        );
    }
}
