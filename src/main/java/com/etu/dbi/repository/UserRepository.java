package com.etu.dbi.repository;

import com.etu.dbi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
