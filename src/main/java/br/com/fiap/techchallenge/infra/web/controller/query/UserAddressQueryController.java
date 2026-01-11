package br.com.fiap.techchallenge.infra.web.controller.query;

import br.com.fiap.techchallenge.core.domain.model.UserAddress;
import br.com.fiap.techchallenge.core.usecase.in.address.FindAddressByIdUseCase;
import br.com.fiap.techchallenge.core.usecase.in.user.FindUserByIdUseCase;
import br.com.fiap.techchallenge.core.usecase.in.useraddress.FindUserAddressByAddressIdUseCase;
import br.com.fiap.techchallenge.core.usecase.in.useraddress.GetUserAddressesSummaryUseCase;
import br.com.fiap.techchallenge.infra.web.dto.user.UserResponse;
import br.com.fiap.techchallenge.infra.web.dto.useraddress.UserAddressSummaryResponse;
import br.com.fiap.techchallenge.infra.web.mapper.user.UserDtoMapper;
import br.com.fiap.techchallenge.infra.web.mapper.useraddress.UserAddressSummaryDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queries")
public class UserAddressQueryController {

    private final FindUserAddressByAddressIdUseCase findUserAddressByAddressIdUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final FindAddressByIdUseCase findAddressByIdUseCase;
    private final GetUserAddressesSummaryUseCase getUserAddressesSummaryUseCase;

    public UserAddressQueryController(FindUserAddressByAddressIdUseCase findUserAddressByAddressIdUseCase, FindUserByIdUseCase findUserByIdUseCase, FindAddressByIdUseCase findAddressByIdUseCase, GetUserAddressesSummaryUseCase getUserAddressesSummaryUseCase) {

        this.findUserAddressByAddressIdUseCase = findUserAddressByAddressIdUseCase;
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.findAddressByIdUseCase = findAddressByIdUseCase;
        this.getUserAddressesSummaryUseCase = getUserAddressesSummaryUseCase;
    }

    @GetMapping("/users/{userId}/addresses")
    public List<UserAddressSummaryResponse> getAddressesByUser(
            @PathVariable String userId
    ){

        return getUserAddressesSummaryUseCase.execute(userId)
                .stream()
                .map(UserAddressSummaryDtoMapper::toResponse)
                .toList();
    }



    @GetMapping("/addresses/{addressId}/users")
    public List<UserResponse> getUserByAddress(
            @PathVariable String addressId
    ){

        findAddressByIdUseCase.execute(addressId);

        List<UserAddress> links =
                findUserAddressByAddressIdUseCase.execute(addressId);

        return links.stream()
                .map(link -> findUserByIdUseCase.execute(link.getUserId()))
                .map(UserDtoMapper::toResponse)
                .toList();
    }

}
