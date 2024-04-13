package com.example.moviebookingapp.service;

import com.example.moviebookingapp.dto.MovieTicketAcknowledgement;
import com.example.moviebookingapp.dto.MovieTicketRequest;
import com.example.moviebookingapp.entity.PaymentInfo;
import com.example.moviebookingapp.entity.TicketInfo;
import com.example.moviebookingapp.repository.PaymentInfoRepo;
import com.example.moviebookingapp.repository.TicketinfoRepo;
import com.example.moviebookingapp.utility.ValidatePaymentInfo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MovieTicketService {

    @Autowired
    TicketinfoRepo ticketinfoRepo;

    @Autowired
    PaymentInfoRepo paymentInfoRepo;

    @Transactional
    public MovieTicketAcknowledgement bookMovieTicket(MovieTicketRequest request) {
        TicketInfo ticketInfo = request.getTicketInfo();
        ticketInfo =   ticketinfoRepo.save(ticketInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        ValidatePaymentInfo.validateCreditLimit(paymentInfo.getAccountNo(), ticketInfo.getTicketPrize());

        paymentInfo.setTicketId(ticketInfo.getId());
        paymentInfo.setAmount(ticketInfo.getTicketPrize());

        paymentInfoRepo.save(paymentInfo);

        return new MovieTicketAcknowledgement("SUCCESSS", ticketInfo.getTicketPrize(), UUID.randomUUID().toString().split("-")[0], ticketInfo);
    }

}
