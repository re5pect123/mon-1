package com.mona.mona.repository;

import com.mona.mona.entity.Kreator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KreatorRepository extends CrudRepository<Kreator, Long>{
}
