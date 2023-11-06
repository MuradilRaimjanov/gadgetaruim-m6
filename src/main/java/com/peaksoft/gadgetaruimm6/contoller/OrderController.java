package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.OrderRequest;
import com.peaksoft.gadgetaruimm6.model.dto.OrderResponse;
import com.peaksoft.gadgetaruimm6.model.dto.ResponseToTheOrderForDelivery;
import com.peaksoft.gadgetaruimm6.model.entity.Order;
import com.peaksoft.gadgetaruimm6.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/orders")
//@Tag(name = "OrderController", description = "API endpoints for managing orders")
@RequiredArgsConstructor
public class OrderController {
    private  final OrderService orderService;

    @PostMapping("save/{review-status}/{basketId}")
    public ResponseToTheOrderForDelivery saveMain(@PathVariable("review-status") String orderReview ,
                                                  @PathVariable("basketId") Long basketId,
                                                  @RequestBody OrderRequest orderRequest) {
        return  orderService.saveMain(orderReview,basketId,orderRequest);
    }

    @PostMapping("save-payment/{id}/{review-status}")
    public OrderResponse savePayment(@PathVariable("id")Long id,@PathVariable ("review-status")
    String orderReview,@RequestBody OrderRequest orderRequest ){
        return orderService.savePayment(id,orderReview,orderRequest);
    }

    @PostMapping("save-finish/{id}/{review-status}")
    public OrderResponse saveReview(@PathVariable("id") Long id, @PathVariable("review-status") String orderReview) {
        return orderService.saveOrderReview(id, orderReview);
    }
    @GetMapping("{id}")
    public Optional<Order> findOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
