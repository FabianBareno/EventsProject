package com.hackerrank.github.controller;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/actors")
public class ActorsController {

    private final ActorService actorService;

    @Autowired
    public ActorsController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors(){
        return new ResponseEntity<>(actorService.getAllActors(), HttpStatus.OK);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Actor> updateAvatarURL(@RequestBody Actor actor){

        try{
            actorService.updateAvatarURL(actor);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (IllegalArgumentException exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
