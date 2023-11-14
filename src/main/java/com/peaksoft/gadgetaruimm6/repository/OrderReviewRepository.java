package com.peaksoft.gadgetaruimm6.repository;

import com.peaksoft.gadgetaruimm6.model.entity.OrderReview;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderReviewRepository extends JpaRepository<OrderReview, Long> {
    @Query("SELECT o FROM OrderReview o WHERE CAST(o.review AS string) = :orderReview")
    Optional<OrderReview> findByOrderReview(@PathParam("orderReview") String orderReview);
}