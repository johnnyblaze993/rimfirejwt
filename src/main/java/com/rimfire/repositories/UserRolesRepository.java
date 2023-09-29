package com.rimfire.repositories;

import java.util.List;

import com.rimfire.entities.UserRoles;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.ORACLE)
public interface UserRolesRepository extends CrudRepository<UserRoles, Long> {
        List<UserRoles> findByUserId(Long userId);
}
