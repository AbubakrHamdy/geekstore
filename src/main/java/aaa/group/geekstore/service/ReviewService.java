package aaa.group.geekstore.service;

import aaa.group.geekstore.model.Review;
import aaa.group.geekstore.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getById(UUID id) {
        return reviewRepository.findById(id);
    }

    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    public Review update(UUID id, Review review) {
        review.setId(id);
        return reviewRepository.save(review);
    }

    public void deleteById(UUID id) {
        reviewRepository.deleteById(id);
    }
}
