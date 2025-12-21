package br.com.fiap.techchallenge.core.usecase.out;

import br.com.fiap.techchallenge.core.domain.model.UserAddress;

import java.util.List;

public interface UserAddressRepositoryPort {

    UserAddress save(UserAddress userAddress);

    void delete(String id);

    List<UserAddress> findByAddressId(String addressId);

    List<UserAddress> findByUserId(String userId);

    UserAddress findPrincipalByUserId(String userId);
}
