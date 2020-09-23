package com.hackerrank.github.controller;

import com.hackerrank.github.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {

    private final EventService eventService;

    @Autowired
    public ResourcesController(EventService eventService) {
        this.eventService = eventService;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteEvents(){
        eventService.deleteRecords();
    }

}
