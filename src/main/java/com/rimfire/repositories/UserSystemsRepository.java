package com.rimfire.repositories;

import java.util.List;

import com.rimfire.entities.UserSystems;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.ORACLE)
public interface UserSystemsRepository extends CrudRepository<UserSystems, Long> {
       List<UserSystems> findByUserId(Long userId);
}