package org.drysliceofbread.web.api;

import org.drysliceofbread.model.Joke;
import org.drysliceofbread.service.IJokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


/**
 * Created by janco on 25.10.2016.
 */
@RestController

public class JokeController {


    @Autowired
    private IJokeService jokeService;

    @RequestMapping(
            value = "api/jokes",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Joke>> getJokes() {
        Collection<Joke> jokes = jokeService.findAll();
        return new ResponseEntity<Collection<Joke>>(jokes, HttpStatus.OK);
    }

    @RequestMapping(
            value = "api/jokes/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Joke> getJoke(@PathVariable("id") Long id) {

        Joke joke = jokeService.findOne(id);
        if (joke == null) {
            return new ResponseEntity<Joke>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Joke>(joke, HttpStatus.OK);
    }

    @RequestMapping(
            value = "api/jokes",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Joke> createJoke(@RequestBody Joke joke) {
        Joke saveJoke = jokeService.create(joke);
        return new ResponseEntity<Joke>(saveJoke, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "api/joke/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Joke> updateJoke(@RequestBody Joke joke) {
        Joke updatedJoke = jokeService.update(joke);
        if (updatedJoke == null) {
            return new ResponseEntity<Joke>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Joke>(updatedJoke, HttpStatus.OK);
    }

    @RequestMapping(
            value = "api/joke/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Joke> deleteGreeting(@PathVariable("id") Long id) {

        jokeService.delete(id);

        return new ResponseEntity<Joke>(HttpStatus.NO_CONTENT);
    }
}
