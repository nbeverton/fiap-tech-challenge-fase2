package br.com.fiap.techchallenge.core.usecase.impl.useraddress;

import br.com.fiap.techchallenge.core.domain.model.UserAddress;
import br.com.fiap.techchallenge.core.usecase.in.useraddress.CreateUserAddressUseCase;
import br.com.fiap.techchallenge.core.usecase.out.UserAddressRepositoryPort;

public class CreateUserAddressUseCaseImpl implements CreateUserAddressUseCase {

    private final UserAddressRepositoryPort userAddressRepository;

    public CreateUserAddressUseCaseImpl(UserAddressRepositoryPort userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }


    @Override
    public UserAddress execute(UserAddress userAddress) {

        return userAddressRepository.save(userAddress);
    }
}
