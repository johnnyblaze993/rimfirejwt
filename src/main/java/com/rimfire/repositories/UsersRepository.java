package com.rimfire.repositories;

import com.rimfire.entities.Users;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.ORACLE)
public interface UsersRepository extends CrudRepository<Users, Long> {
  Users findByUserId(Long userId);

  @Query("SELECT * FROM USERS WHERE USERNAME = :username AND FIRST_NAME = :firstName")
  Optional<Users> findByUsernameAndFirstName(String username, String firstName);
}
