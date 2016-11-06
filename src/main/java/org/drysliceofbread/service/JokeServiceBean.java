package org.drysliceofbread.service;

import org.drysliceofbread.model.Joke;
import org.drysliceofbread.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by janco on 23.10.2016.
 */
@Service
public class JokeServiceBean implements IJokeService {

    @Autowired
    private JokeRepository jokeRepository;

    @Override
    public Joke findOne(Long id) {
        Joke findJoke = jokeRepository.findOne(id);
        if (findJoke == null) return null;
        return findJoke;
    }

    @Override
    public Joke create(Joke joke) {
        Joke saveJoke = jokeRepository.save(joke);
        if (joke.getId() != null) return null;

        return saveJoke;
    }

    @Override
    public Collection<Joke> findAll() {
        Collection<Joke> joke = jokeRepository.findAll();
        return joke;
    }
    @Override
    public Joke update(Joke joke) {
        Joke joke1=findOne(joke.getId());
        if (joke1==null) return null;

        Joke updatedJoke = jokeRepository.save(joke);

        return updatedJoke;
    }

    @Override
    public void delete(Long id) {
        jokeRepository.delete(id);

    }
}
