package br.com.fiap.techchallenge.core.usecase.impl.useraddress;

import br.com.fiap.techchallenge.core.domain.exception.address.AddressNotFoundException;
import br.com.fiap.techchallenge.core.domain.model.Address;
import br.com.fiap.techchallenge.core.domain.model.UserAddress;
import br.com.fiap.techchallenge.core.usecase.in.user.FindUserByIdUseCase;
import br.com.fiap.techchallenge.core.usecase.in.useraddress.AddAddressToUserInput;
import br.com.fiap.techchallenge.core.usecase.in.useraddress.AddAddressToUserUseCase;
import br.com.fiap.techchallenge.core.usecase.out.AddressRepositoryPort;
import br.com.fiap.techchallenge.core.usecase.out.UserAddressRepositoryPort;
import br.com.fiap.techchallenge.core.usecase.out.UserAddressSummaryOutput;

import java.util.Comparator;
import java.util.List;

public class AddAddressToUserUseCaseImpl implements AddAddressToUserUseCase {

    private final FindUserByIdUseCase findUserByIdUseCase;
    private final AddressRepositoryPort addressRepository;
    private final UserAddressRepositoryPort userAddressRepository;

    public AddAddressToUserUseCaseImpl(FindUserByIdUseCase findUserByIdUseCase, AddressRepositoryPort addressRepository, UserAddressRepositoryPort userAddressRepository) {
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.addressRepository = addressRepository;
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public List<UserAddressSummaryOutput> execute(AddAddressToUserInput input) {

        //1. Validate if the user exists
        findUserByIdUseCase.execute(input.userId());

        //2. Validate if the address exists
        Address newAddress = addressRepository.findById(input.addressId())
                .orElseThrow(() ->
                        new AddressNotFoundException(input.addressId())
                );

        //3. Search for the current primary address (if it exists)
        userAddressRepository.findPrincipalByUserId(input.userId())
                .ifPresent(existingPrincipal -> {
                    existingPrincipal.setPrincipal(false);

                    userAddressRepository.save(existingPrincipal);
                });

        //4. Create a new link as primary
        UserAddress newUserAddress = new UserAddress(
                input.userId(),
                newAddress.getId(),
                input.addressType(),
                input.label(),
                true
        );

        userAddressRepository.save(newUserAddress);

        //5. Search all user's links
        List<UserAddress> links =
                userAddressRepository.findByUserId(input.userId());

        //6. Assembles the summary output + sorts (principal first)
        return links.stream()
                .map(link -> {
                    Address address = addressRepository.findById(link.getAddressId())
                            .orElseThrow(() ->
                                    new AddressNotFoundException(link.getUserId())
                            );

                    return new UserAddressSummaryOutput(
                            link.getType(),
                            address.getStreetName(),
                            address.getStreetNumber(),
                            address.getNeighborhood(),
                            address.getCity(),
                            address.getStateProvince(),
                            address.getAdditionalInfo(),
                            link.isPrincipal()
                    );
                })
                .sorted(Comparator.comparing(UserAddressSummaryOutput::principal).reversed())
                .toList();
    }
}
