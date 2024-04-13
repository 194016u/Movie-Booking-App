package com.example.moviebookingapp.controller;

import com.example.moviebookingapp.dto.MovieTicketAcknowledgement;
import com.example.moviebookingapp.dto.MovieTicketRequest;
import com.example.moviebookingapp.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MovieTicketController {
    @Autowired
    MovieTicketService service;

    @PostMapping("/bookMovieTicket")
    public MovieTicketAcknowledgement bookTicket(@RequestBody MovieTicketRequest request) {
        return service.bookMovieTicket(request);
    }

}
