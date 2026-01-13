package br.com.fiap.techchallenge.core.usecase.impl.useraddress;

import br.com.fiap.techchallenge.core.domain.model.UserAddress;
import br.com.fiap.techchallenge.core.usecase.in.useraddress.FindAllUserAddressUseCase;
import br.com.fiap.techchallenge.core.usecase.out.UserAddressRepositoryPort;

import java.util.List;

public class FindAllUserAddressUseCaseImpl implements FindAllUserAddressUseCase {

    private final UserAddressRepositoryPort userAddressRepository;

    public FindAllUserAddressUseCaseImpl(UserAddressRepositoryPort userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public List<UserAddress> execute() {
        return userAddressRepository.findAll();
    }
}
