package com.hackerrank.github.services;

import com.hackerrank.github.model.Repo;

import java.util.Optional;

public interface RepoService {

    void createRepo(Repo repo);

    Optional<Repo> getRepoById(Long id);

    void deleteRecords();
}
