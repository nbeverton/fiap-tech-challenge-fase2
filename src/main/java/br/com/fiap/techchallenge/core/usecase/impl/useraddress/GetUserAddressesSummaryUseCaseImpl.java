package br.com.fiap.techchallenge.core.usecase.impl.useraddress;

import br.com.fiap.techchallenge.core.domain.exception.address.AddressNotFoundException;
import br.com.fiap.techchallenge.core.domain.model.Address;
import br.com.fiap.techchallenge.core.domain.model.UserAddress;
import br.com.fiap.techchallenge.core.usecase.in.user.FindUserByIdUseCase;
import br.com.fiap.techchallenge.core.usecase.in.useraddress.GetUserAddressesSummaryUseCase;
import br.com.fiap.techchallenge.core.usecase.out.AddressRepositoryPort;
import br.com.fiap.techchallenge.core.usecase.out.UserAddressRepositoryPort;
import br.com.fiap.techchallenge.core.usecase.out.UserAddressSummaryOutput;

import java.util.Comparator;
import java.util.List;

public class GetUserAddressesSummaryUseCaseImpl implements GetUserAddressesSummaryUseCase {

    private final FindUserByIdUseCase findUserByIdUseCase;
    private final UserAddressRepositoryPort userAddressRepository;
    private final AddressRepositoryPort addressRepository;

    public GetUserAddressesSummaryUseCaseImpl(FindUserByIdUseCase findUserByIdUseCase, UserAddressRepositoryPort userAddressRepository, AddressRepositoryPort addressRepository) {
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.userAddressRepository = userAddressRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    public List<UserAddressSummaryOutput> execute(String userId) {

        // 1. Validates if the user exists
        findUserByIdUseCase.execute(userId);

        // 2. Searches for the UserAddress links
        List<UserAddress> links =
                userAddressRepository.findByUserId(userId);

        // 3. Assembles the summarized output
        return links.stream()
                .map(link -> {
                    Address address = addressRepository.findById(link.getAddressId())
                            .orElseThrow(() ->
                                    new AddressNotFoundException(link.getAddressId())
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
