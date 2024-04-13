package com.example.moviebookingapp.repository;

import com.example.moviebookingapp.entity.TicketInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketinfoRepo extends JpaRepository<TicketInfo, String> {
}
