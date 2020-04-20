package com.mahdiyar.ddd.client;

import com.mahdiyar.ddd.RepositoryBase;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
public interface ClientRepository extends RepositoryBase<ClientModel, UUID> {
    Optional<ClientModel> findByName(String name);
}
