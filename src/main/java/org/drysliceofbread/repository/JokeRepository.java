package org.drysliceofbread.repository;

import org.drysliceofbread.model.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by janco on 16.10.2016.
 */
@Repository
public interface JokeRepository extends JpaRepository<Joke, Long> {
}
