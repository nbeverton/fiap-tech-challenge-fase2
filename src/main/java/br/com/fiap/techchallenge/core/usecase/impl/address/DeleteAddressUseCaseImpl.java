package br.com.fiap.techchallenge.core.usecase.impl.address;

import br.com.fiap.techchallenge.core.domain.exception.address.AddressNotFoundException;
import br.com.fiap.techchallenge.core.domain.exception.useraddress.CannotRemovePrincipalAddressException;
import br.com.fiap.techchallenge.core.domain.model.UserAddress;
import br.com.fiap.techchallenge.core.usecase.in.address.DeleteAddressUseCase;
import br.com.fiap.techchallenge.core.usecase.out.AddressRepositoryPort;
import br.com.fiap.techchallenge.core.usecase.out.UserAddressRepositoryPort;

import java.util.List;

public class DeleteAddressUseCaseImpl implements DeleteAddressUseCase {

    private final AddressRepositoryPort addressRepository;
    private final UserAddressRepositoryPort userAddressRepository;


    public DeleteAddressUseCaseImpl(AddressRepositoryPort addressRepository, UserAddressRepositoryPort userAddressRepository){
        this.addressRepository = addressRepository;
        this.userAddressRepository = userAddressRepository;
    }


    @Override
    public void execute(String id) {

        // 1. Check if the address exists
        addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(id));

        // 2. Find links with users
        List<UserAddress> links =
                userAddressRepository.findByAddressId(id);

        // 3. Rule: cannot delete a primary address
        boolean hasPrincipalLink = links.stream()
                        .anyMatch(UserAddress::isPrincipal);

        if(hasPrincipalLink){
            throw new CannotRemovePrincipalAddressException(id);
        }

        // 4. Remove secondary links
        links.forEach(link ->
                userAddressRepository.deleteById(link.getId())
        );

        // 5. Delete the Address
        addressRepository.delete(id);
    }
}
