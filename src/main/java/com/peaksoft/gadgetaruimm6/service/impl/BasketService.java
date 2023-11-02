package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.exception.ProductNotFoundException;
import com.peaksoft.gadgetaruimm6.model.dto.BasketResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.BasketMapper;
import com.peaksoft.gadgetaruimm6.model.entity.Basket;
import com.peaksoft.gadgetaruimm6.model.entity.Product;
import com.peaksoft.gadgetaruimm6.model.entity.User;
import com.peaksoft.gadgetaruimm6.repository.BasketRepository;
import com.peaksoft.gadgetaruimm6.repository.ProductRepository;
import com.peaksoft.gadgetaruimm6.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BasketService {

    BasketRepository basketRepository;
    ProductRepository productRepository;
    BasketMapper basketMapper;
    UserRepository userRepository;

    public BasketResponse addToBasket(Long id, Principal principal) {
        List<Product> products = new ArrayList<>();
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not found"));
        double totalSum = 0;
        double currPrice = 0;
        double discPrice = 0;
        double percent = 0;
        int count = 0;
        User user = userRepository.findByEmail(principal.getName());
        if (user.getBasket().getId() != null && product.getQuantityOfProducts() > 0) {
            Basket basket = basketRepository.findById(user.getBasket().getId()).orElseThrow(()-> new RuntimeException("Basket not found"));
            product.setBasket(basket);
            product.setQuantityOfProducts(product.getQuantityOfProducts() - 1);
            product.setInBasket(true);
            productRepository.save(product);
            products = basket.getProducts();
                for (Product pod : products) {
                    totalSum += pod.getPrice();
                    basket.setSum(totalSum);
                    percent += pod.getPrice() * pod.getDiscount().getPercent()/100;
                    currPrice = totalSum - percent;
                    basket.setEndSum(currPrice);
                    discPrice = currPrice - totalSum;
                    basket.setDiscountPercentSum(discPrice);
                    count++;
                }

                basket.setQuantityOfProducts(count);
                basketRepository.save(basket);
        } else {
            throw new RuntimeException("Not found basket id");
        }
        return BasketResponse.builder()
                .allSum(totalSum)
                .countDiscPrice(discPrice)
                .endSum(currPrice)
                .countOfProduct(products.size())
                .products(basketMapper.mapToResponse(products)).build();
    }

    public BasketResponse removeByIdProduct(Long id, Principal principal) {
        Product productBD = productRepository.findById(id).orElseThrow(()-> new RuntimeException("The product not found"));
        User user = userRepository.findByEmail(principal.getName());
        Basket basket = basketRepository.findById(user.getBasket().getId()).orElseThrow(()-> new RuntimeException("Basket id not found"));
        List<Product> products = basket.getProducts();
        int size = products.size();
        double minusSum = 0;
        double minusEndSum = 0;
        double discountPrice = 0;
        int x = 0;
        for(int i = 0; i < products.size(); i++) {
            if (size > 1) {
                if (products.get(i).getId().intValue() == productBD.getId().intValue()) {
                    products.get(i).setBasket(null);
                    products.get(i).setInBasket(false);
                    products.get(i).setQuantityOfProducts(products.get(i).getQuantityOfProducts() + 1);
                    productRepository.save(products.get(i));
                    minusSum = basket.getSum() - products.get(i).getPrice();
                    double discPrice = products.get(i).getPrice() * products.get(i).getDiscount().getPercent() / 100;
                    minusEndSum = basket.getEndSum() - products.get(i).getPrice() + discPrice;
                    discountPrice = minusSum - minusEndSum;
                    basket.setSum(minusSum);
                    basket.setEndSum(minusEndSum);
                    basket.setDiscountPercentSum(discountPrice);
                    x++;
                    basket.setQuantityOfProducts(products.size() - x);
                    products.remove(i);
                    basket.setProducts(products);

                }
            } else {
                if (products.get(i).getId().intValue() == productBD.getId().intValue()) {
                    products.get(i).setBasket(null);
                    products.get(i).setInBasket(false);
                    products.get(i).setQuantityOfProducts(products.get(i).getQuantityOfProducts() + 1);
                    productRepository.save(products.get(i));
                    basket.setSum(minusSum);
                    basket.setEndSum(minusEndSum);
                    basket.setDiscountPercentSum(discountPrice);
                    basket.setQuantityOfProducts(0);
                    basket.setProducts(new ArrayList<>());
                }
            }
        }
        if(products.isEmpty()) {
            return BasketResponse.builder()
                    .massage("The basket is empty")
                    .build();
        }
        basketRepository.save(basket);
        return BasketResponse.builder()
                .allSum(basket.getSum())
                .endSum(basket.getEndSum())
                .countDiscPrice(basket.getDiscountPercentSum())
                .countOfProduct(basket.getQuantityOfProducts())
                .products(basketMapper.mapToResponse(basket.getProducts()))
                .build();
    }

    public BasketResponse removeAllProductsFromBasket(Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        Basket basket = basketRepository.findById(user.getBasket().getId()).orElseThrow(()-> new RuntimeException("Basket id not found"));
        List<Product> products = basket.getProducts();
        int count = 0;
        for (Product product : products) {
            basket.setQuantityOfProducts(0);
            basket.setSum(0);
            basket.setDiscountPercentSum(0);
            basket.setEndSum(0);
            product.setBasket(null);
            count++;
            productRepository.save(product);
        }
        if (products.isEmpty()) {
            return BasketResponse.builder()
                    .products(new ArrayList<>())
                    .countOfProduct(0)
                    .allSum(0)
                    .endSum(0)
                    .countDiscPrice(0)
                    .massage("The basket is empty!!!")
                    .build();
        }
        return BasketResponse.builder()
                .products(new ArrayList<>())
                .countOfProduct(0)
                .allSum(basket.getSum())
                .endSum(basket.getEndSum())
                .countDiscPrice(basket.getDiscountPercentSum())
                .massage("All products successfully removed")
                .build();

    }

    public BasketResponse getBasketById(Principal principal) {
        Basket basket = userRepository.findByEmail(principal.getName()).getBasket();
        return BasketResponse.builder()
                .allSum(basket.getSum())
                .endSum(basket.getEndSum())
                .countDiscPrice(basket.getDiscountPercentSum())
                .countOfProduct(basket.getProducts().size())
                .products(basketMapper.mapToResponse(basket.getProducts()))
                .build();
    }
}
