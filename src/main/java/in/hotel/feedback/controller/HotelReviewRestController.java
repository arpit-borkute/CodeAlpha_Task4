package in.hotel.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.hotel.feedback.entity.Hotel;
import in.hotel.feedback.entity.Review;
import in.hotel.feedback.service.HotelReviewService;

@RestController
@RequestMapping("/hotels")
public class HotelReviewRestController {

	@Autowired
	private HotelReviewService hotelReviewService;

	@PostMapping("/addHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelReviewService.createHotel(hotel));
	}

	@GetMapping("/GetHotelById/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(hotelReviewService.getHotelById(id));
	}

	@GetMapping("/getAllHotels")
	public ResponseEntity<List<Hotel>> getAllHotel() {
		return ResponseEntity.status(HttpStatus.OK).body(hotelReviewService.getAllHotels());
	}

	@PostMapping("/add-review")
	public ResponseEntity<Review> createRating(@RequestBody Review review) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelReviewService.createReview(review));

	}

	@GetMapping("/getAllReviews")
	public ResponseEntity<List<Review>> getAllRating() {
		return ResponseEntity.ok(hotelReviewService.getAllReview());

	}

	@GetMapping("/reviews/filter")
	public List<Review> filterReviewsByRating(@RequestParam int minRating) {
		return hotelReviewService.filterByMinRating(minRating);
	}

	@GetMapping("/reviews/sort")
	public List<Review> sortReviewsByRating() {
		return hotelReviewService.sortByRatingDesc();
	}
}
