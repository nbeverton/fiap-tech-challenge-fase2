package br.com.fiap.techchallenge.infra.persistence.repository;

import br.com.fiap.techchallenge.infra.persistence.documents.UserAddressDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringUserAddressRepository extends MongoRepository<UserAddressDocument, String> {
}
