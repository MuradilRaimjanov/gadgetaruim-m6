package com.peaksoft.gadgetaruimm6.repository;

import com.peaksoft.gadgetaruimm6.model.entity.Product;
import com.peaksoft.gadgetaruimm6.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComparisonRepository extends JpaRepository<User, Long> {
    @Query("select distinct p from User u join u.products p where u.id = :userId and p.categoryType = 'SMARTPHONES'")
    List<Product> smartphones(Long userId);

    @Query("select  distinct p from User u join u.products p where u.id = :userId and p.categoryType = 'LAPTOPS'")
    List<Product> laptops(Long userId);

    @Query("select distinct p from User u join u.products p where u.id = :userId and p.categoryType = 'TABLETS'")
    List<Product> tablets(Long userId);

    @Query("select distinct p from User u join u.products p where u.id = :userId and p.categoryType = 'SMARTWATCH'")
    List<Product> smartWatch(Long userId);

    @Query("select p from Product p join p.users u where u = :user")
    List<Product> findProductsByUser(User user);


}
