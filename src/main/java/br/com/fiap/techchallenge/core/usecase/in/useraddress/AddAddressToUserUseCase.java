package br.com.fiap.techchallenge.core.usecase.in.useraddress;

import br.com.fiap.techchallenge.core.domain.model.UserAddress;

public interface AddAddressToUserUseCase {

    UserAddress execute(AddAddressToUserInput input);
}
