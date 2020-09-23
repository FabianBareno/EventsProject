package com.hackerrank.github.repositories;

import com.hackerrank.github.model.Repo;
import org.springframework.data.repository.CrudRepository;

public interface RepoRepository extends CrudRepository<Repo, Long> {
}
