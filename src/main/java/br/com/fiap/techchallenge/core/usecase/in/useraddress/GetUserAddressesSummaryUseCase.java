package br.com.fiap.techchallenge.core.usecase.in.useraddress;

import br.com.fiap.techchallenge.core.usecase.out.UserAddressSummaryOutput;

import java.util.List;

public interface GetUserAddressesSummaryUseCase {

    List<UserAddressSummaryOutput> execute(String userId);
}
