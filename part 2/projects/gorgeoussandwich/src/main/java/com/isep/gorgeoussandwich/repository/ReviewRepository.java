package com.isep.gorgeoussandwich.repository;

import com.isep.gorgeoussandwich.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByUserIdAndSandwichId(long userId, long sandwichId);

    List<Review> findBySandwichId(long sandwichId);

}
