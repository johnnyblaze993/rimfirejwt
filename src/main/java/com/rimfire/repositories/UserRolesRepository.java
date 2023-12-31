package com.rimfire.repositories;

import com.rimfire.entities.UserRoles;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.ORACLE)
public interface UserRolesRepository extends CrudRepository<UserRoles, Long> {
  List<UserRoles> findByUserId(Long userId);

  @Query("SELECT Role_ID FROM USER_ROLES WHERE USERID = :userId")
  Optional<Long> findRoleIdByUserId(Long userId);
}
