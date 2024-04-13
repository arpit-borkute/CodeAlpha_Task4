package in.hotel.feedback.service;

import java.util.List;
import in.hotel.feedback.entity.Hotel;
import in.hotel.feedback.entity.Review;

public interface HotelReviewService {

	public Hotel createHotel(Hotel hotel);

	public List<Hotel> getAllHotels();

	public Hotel getHotelById(String id);

	public Review createReview(Review review);

	public List<Review> getAllReview();

	public List<Review> filterByMinRating(int minRating);

	public List<Review> sortByRatingDesc();

}
