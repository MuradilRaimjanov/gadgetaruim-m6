package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.WishlistResponse;
import com.peaksoft.gadgetaruimm6.service.impl.WishlistService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wishlist/")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class WishlistController {

    WishlistService wishlistService;

    @PostMapping("/save/{id}")
    public WishlistResponse saveProduct(@PathVariable("id") Long id, Principal principal) {
        return wishlistService.saveWishProduct(id, principal);
    }

    @PutMapping("/delete/{id}")
    public WishlistResponse deleteByid(@PathVariable("id") Long id, Principal principal) {
        return wishlistService.deleteProductFromWishlist(id, principal);
    }

    @GetMapping("/get-all/")
    public WishlistResponse getAll(Principal principal) {
        return wishlistService.getAllProductsFromWishlist(principal);
    }

    @PutMapping("/delete-all/")
    public WishlistResponse deleteAll(Principal principal) {
        return wishlistService.deleteAllProducts(principal);
    }

    @GetMapping("/get-wishlist/")
    public WishlistResponse getWishlist(Principal principal) {
        return wishlistService.getWishlist(principal);
    }
}
