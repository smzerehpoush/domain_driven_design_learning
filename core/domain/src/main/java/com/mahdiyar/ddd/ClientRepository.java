package com.mahdiyar.ddd;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Repository
public interface ClientRepository extends RepositoryBase<ClientModel, UUID> {
    Optional<ClientModel> findByName(String name);
}
