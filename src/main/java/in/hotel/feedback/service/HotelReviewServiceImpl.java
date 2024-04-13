package in.hotel.feedback.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hotel.feedback.entity.Hotel;
import in.hotel.feedback.entity.Review;
import in.hotel.feedback.repository.HotelRepo;
import in.hotel.feedback.repository.ReviewRepo;

@Service
public class HotelReviewServiceImpl implements HotelReviewService {

	@Autowired
	private HotelRepo hotelRepo;

	@Autowired
	private ReviewRepo reviewRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotelById(String id) {
		return hotelRepo.findById(id).get();
	}

	@Override
	public Review createReview(Review review) {
		return reviewRepo.save(review);
	}

	@Override
	public List<Review> getAllReview() {
		return reviewRepo.findAll();
	}

	@Override
	public List<Review> filterByMinRating(int minRating) {
		return reviewRepo.findAll().stream().filter(review -> review.getRating() >= minRating)
				.collect(Collectors.toList());
	}

	@Override
	public List<Review> sortByRatingDesc() {
		return reviewRepo.findAllByOrderByRatingDesc();
	}

}
