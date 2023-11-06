package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.OrderRequest;
import com.peaksoft.gadgetaruimm6.model.dto.OrderResponse;
import com.peaksoft.gadgetaruimm6.model.dto.ResponseToTheOrderForDelivery;
import com.peaksoft.gadgetaruimm6.model.entity.Order;
import com.peaksoft.gadgetaruimm6.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/orders")
@Tag(name = "Order controller")
@RequiredArgsConstructor
public class OrderController {
    private  final OrderService orderService;

    @PostMapping("save/{review-status}/{basketId}")
    @Operation(description = "This method is created so that the user can place an order by the basket id")
    public ResponseToTheOrderForDelivery saveMain(@PathVariable("review-status") String orderReview ,
                                                  @PathVariable("basketId") Long basketId,
                                                  @RequestBody OrderRequest orderRequest) {
        return  orderService.saveMain(orderReview,basketId,orderRequest);
    }

    @PostMapping("save-payment/{id}/{review-status}")
    @Operation(description ="With this method, the entire authenticated list of users can save the order payment")
    public OrderResponse savePayment(@PathVariable("id")Long id,@PathVariable ("review-status")
    String orderReview,@RequestBody OrderRequest orderRequest ){
        return orderService.savePayment(id,orderReview,orderRequest);
    }

    @PostMapping("save-finish/{id}/{review-status}")
    @Operation(description ="Using this method, the User can save the total amount of basket items in an already created order by its identifier")
    public OrderResponse saveReview(@PathVariable("id") Long id, @PathVariable("review-status") String orderReview) {
        return orderService.saveOrderReview(id, orderReview);
    }
    @GetMapping("{id}")
    @Operation(description ="This method find order by id")
    public Optional<Order> findOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
