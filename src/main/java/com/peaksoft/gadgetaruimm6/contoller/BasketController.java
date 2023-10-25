package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.mapper.BasketResponse;
import com.peaksoft.gadgetaruimm6.service.impl.BasketService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BasketController {

    BasketService basketService;

    @PostMapping("/add/{id}")
    public BasketResponse addToBasket(@PathVariable("id") Long id, Principal principal) {
        return basketService.addToBasket(id, principal);
    }

    @PostMapping("/remove-by-id/{id}")
    public BasketResponse removeProduct(@PathVariable("id") Long id, Principal principal) {
        return basketService.removeByIdProduct(id, principal);
    }

    @PostMapping("/remove-all/")
    public BasketResponse removeAll(Principal principal) {
        return basketService.removeAllProductsFromBasket(principal);
    }

    @GetMapping("/get-basket/")
    public BasketResponse getBasketById(Principal principal) {
        return basketService.getBasketById(principal);
    }
}
