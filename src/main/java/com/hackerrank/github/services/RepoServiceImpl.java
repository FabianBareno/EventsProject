package com.hackerrank.github.services;

import com.hackerrank.github.model.Repo;
import com.hackerrank.github.repositories.RepoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class RepoServiceImpl implements RepoService {

    private final RepoRepository repoRepository;

    @Autowired
    public RepoServiceImpl(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    @Override
    @Transactional
    public void createRepo(Repo repo) {
        repoRepository.save(repo);
    }

    @Override
    public Optional<Repo> getRepoById(Long id) {
        return repoRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteRecords() {
        repoRepository.deleteAll();
    }

}
