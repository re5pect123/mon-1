package com.mona.mona.repository;

import com.mona.mona.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository  extends CrudRepository<Users, Long>{
}
