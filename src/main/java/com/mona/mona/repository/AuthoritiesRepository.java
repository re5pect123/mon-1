package com.mona.mona.repository;

import com.mona.mona.entity.Authorities;
import org.springframework.data.repository.CrudRepository;

public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {

    Authorities findByUsername(String username);

}
