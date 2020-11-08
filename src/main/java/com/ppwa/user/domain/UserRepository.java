package com.ppwa.user.domain;

import com.ppwa.user.domain.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
