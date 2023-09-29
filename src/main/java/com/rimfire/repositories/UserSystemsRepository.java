package com.rimfire.repositories;

import java.util.List;
import java.util.Optional;

import com.rimfire.entities.UserSystems;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.ORACLE)
public interface UserSystemsRepository extends CrudRepository<UserSystems, Long> {
       List<UserSystems> findByUserId(Long userId);

       @Query("SELECT SYSTEM_ID FROM USER_SYSTEMS WHERE USER_ID = :userId")
       Optional<Long> findSystemIdByUserId(Long userId);
}