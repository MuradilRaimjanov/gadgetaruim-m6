package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.model.dto.WishlistResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.WishlistMapper;
import com.peaksoft.gadgetaruimm6.model.entity.Product;
import com.peaksoft.gadgetaruimm6.model.entity.User;
import com.peaksoft.gadgetaruimm6.model.entity.Wishlist;
import com.peaksoft.gadgetaruimm6.repository.ProductRepository;
import com.peaksoft.gadgetaruimm6.repository.UserRepository;
import com.peaksoft.gadgetaruimm6.repository.WishlistRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class WishlistService {

    ProductRepository productRepository;
    WishlistRepository wishlistRepository;
    UserRepository userRepository;
    WishlistMapper wishlistMapper;

    public WishlistResponse saveWishProduct(Long id, Principal principal) {
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("The product not found"));
        User user = userRepository.findByEmail(principal.getName());
        Wishlist wishlist = wishlistRepository.findById(user.getWishlist().getId()).orElseThrow(()-> new RuntimeException("The wishlist id not found"));
        product.setWishlist(wishlist);
        productRepository.save(product);
        wishlist.setCountOfProduct(wishlist.getProducts().size());
        wishlistRepository.save(wishlist);
        return WishlistResponse.builder()
                .countProduct(wishlist.getProducts().size())
                .products(wishlistMapper.mapToResponse(wishlist.getProducts()))
                .build();
    }
    public WishlistResponse deleteProductFromWishlist(Long id, Principal principal) {
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("The product not found"));
        User user = userRepository.findByEmail(principal.getName());
        Wishlist wishlist = wishlistRepository.findById(user.getWishlist().getId()).orElseThrow(()-> new RuntimeException("The wishlist not found"));

        product.setWishlist(null);
        productRepository.save(product);
        List<Product> products = wishlist.getProducts();
        return WishlistResponse.builder()
                .countProduct(products.size())
                .products(wishlistMapper.mapToResponse(products))
                .build();
    }

    public WishlistResponse getAllProductsFromWishlist(Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        Wishlist wishlist = wishlistRepository.findById(user.getWishlist().getId()).orElseThrow(()-> new RuntimeException("The wishlist not found"));
        return WishlistResponse.builder()
                .products(wishlistMapper.mapToResponse(wishlist.getProducts()))
                .countProduct(wishlist.getProducts().size())
                .build();
    }

    public WishlistResponse deleteAllProducts(Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        Wishlist wishlist = wishlistRepository.findById(user.getWishlist().getId()).orElseThrow(()-> new RuntimeException("The wishlist not found"));
        List<Product> products = wishlist.getProducts();
        for (Product product : products) {
            product.setWishlist(null);
            productRepository.save(product);
        }
        products.clear();
        wishlist.setProducts(products);
        return WishlistResponse.builder()
                .products(new ArrayList<>())
                .countProduct(products.size())
                .build();
    }

    public WishlistResponse getWishlist(Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        Wishlist wishlist = wishlistRepository.findById(user.getWishlist().getId()).orElseThrow(()-> new RuntimeException("The wishlist not found"));
        return WishlistResponse.builder()
                .products(wishlistMapper.mapToResponse(wishlist.getProducts()))
                .countProduct(wishlist.getProducts().size())
                .build();
    }
}
