package com.example.demo.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	public Review addReview(Long bookId, String comment, int rating) {
        Review review = new Review();
        review.setComment(comment);
        review.setRating(rating);
        
        return reviewRepository.save(review);
	}

	public List<Review> getReviewsByBookId(Long id) {
		
		try {
			
			List<Review> reviews = reviewRepository.findByBook(id);
			if(reviews!= null ) {
				return reviews;
			}
			return Collections.emptyList();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
