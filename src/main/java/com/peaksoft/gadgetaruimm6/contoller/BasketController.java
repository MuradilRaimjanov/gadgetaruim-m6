package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.BasketResponse;
import com.peaksoft.gadgetaruimm6.service.impl.BasketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Tag(name = "Basket controller ")
public class BasketController {

    BasketService basketService;

    @PostMapping("/add/{id}")
    @Operation(description = "This is method adds to basket")
    public BasketResponse addToBasket(@PathVariable("id") Long id, Principal principal) {
        return basketService.addToBasket(id, principal);
    }

    @PostMapping("/remove-by-id/{id}")
    @Operation(description = "This is method for remove a product using an id ")
    public BasketResponse removeProduct(@PathVariable("id") Long id, Principal principal) {
        return basketService.removeByIdProduct(id, principal);
    }

    @PostMapping("/remove-all/")
    @Operation(description = "This is method remove all products")
    public BasketResponse removeAll(Principal principal) {
        return basketService.removeAllProductsFromBasket(principal);
    }

    @GetMapping("/get-basket/")
    @Operation(description = "Using this method gets the basket by id ")
    public BasketResponse getBasketById(Principal principal) {
        return basketService.getBasketById(principal);
    }
}
