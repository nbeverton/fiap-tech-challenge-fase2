package br.com.fiap.techchallenge.core.usecase.impl.user;

import br.com.fiap.techchallenge.core.domain.exception.user.UserNotFoundException;
import br.com.fiap.techchallenge.core.domain.model.UserAddress;
import br.com.fiap.techchallenge.core.usecase.in.user.DeleteUserUseCase;
import br.com.fiap.techchallenge.core.usecase.out.UserAddressRepositoryPort;
import br.com.fiap.techchallenge.core.usecase.out.UserRepositoryPort;

import java.util.List;

public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserRepositoryPort userRepository;
    private final UserAddressRepositoryPort userAddressRepository;

    public DeleteUserUseCaseImpl(UserRepositoryPort userRepository, UserAddressRepositoryPort userAddressRepository){
        this.userRepository = userRepository;
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public void execute(String id) {

        //1. Check if the user exists
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        //2. Find links with address
        List<UserAddress> links =
                userAddressRepository.findByUserId(id);

        //3. Remove links
        links.forEach(link ->
                userAddressRepository.deleteById(link.getId())
        );

        //4. Delete the user
        userRepository.deleteById(id);
    }
}
