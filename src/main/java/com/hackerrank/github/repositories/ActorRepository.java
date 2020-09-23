package com.hackerrank.github.repositories;

import com.hackerrank.github.model.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Long> {
}
