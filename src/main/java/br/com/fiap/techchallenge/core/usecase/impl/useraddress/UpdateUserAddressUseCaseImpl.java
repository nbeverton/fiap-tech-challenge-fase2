package br.com.fiap.techchallenge.core.usecase.impl.useraddress;

import br.com.fiap.techchallenge.core.domain.model.UserAddress;
import br.com.fiap.techchallenge.core.usecase.in.useraddress.UpdateUserAddressUseCase;
import br.com.fiap.techchallenge.core.usecase.out.UserAddressRepositoryPort;

public class UpdateUserAddressUseCaseImpl implements UpdateUserAddressUseCase {

    private final UserAddressRepositoryPort userAddressRepository;

    public UpdateUserAddressUseCaseImpl(UserAddressRepositoryPort userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public UserAddress execute(String id, UserAddress userAddress) {

        UserAddress existingUserAddress = userAddressRepository.findUserAddressById(id)
                        .orElseThrow(() -> new RuntimeException("User Address not found with id: " + id));

        existingUserAddress.updateType(userAddress.getType());
        existingUserAddress.updateLabel(userAddress.getLabel());
        existingUserAddress.updatePrincipal(userAddress.isPrincipal());

        return userAddressRepository.save(existingUserAddress);
    }
}
