package org.drysliceofbread.service;

import org.drysliceofbread.model.Joke;

import java.util.Collection;

/**
 * Created by janco on 23.10.2016.
 */
public interface IJokeService {

    Joke findOne(Long id);

    Joke create(Joke joke);

    Collection<Joke> findAll();

    Joke update(Joke joke);

    void delete(Long id);

}
