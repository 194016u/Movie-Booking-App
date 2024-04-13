package com.example.moviebookingapp.repository;

import com.example.moviebookingapp.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, Long> {
}
