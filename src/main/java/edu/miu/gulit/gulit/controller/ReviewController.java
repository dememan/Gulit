package edu.miu.gulit.gulit.controller;
import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.domain.Review;
import edu.miu.gulit.gulit.repository.ReviewRepository;
import edu.miu.gulit.gulit.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping
    public List<Review> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("{id}")
    public Review findById(@PathVariable("id") long id) {
        return reviewService.findById(id);
    }

    @PostMapping("/add")
    public void addReview(@RequestBody Review review) {
        reviewService.addReview(review);
    }

    @PostMapping("{id}/delete")
    public void deleteReviewById(@PathVariable("id") long id) {
        reviewService.deleteReviewById(id);
    }

    @GetMapping({"{id}/product"})
    public List<Review> findReviewByProduct(@RequestBody Product product) {

        return reviewService.findReviewByProduct(product);
    }

    @PutMapping("{id}")
    public void updateReview(@PathVariable("id")long id) {
        reviewService.updateReview(id);
    }
}

