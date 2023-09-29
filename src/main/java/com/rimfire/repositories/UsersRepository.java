package com.rimfire.repositories;

import com.rimfire.entities.Users;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.ORACLE)
public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findByUserId(Long userId);
}

