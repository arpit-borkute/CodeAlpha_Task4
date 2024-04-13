package in.hotel.feedback.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.hotel.feedback.entity.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

	List<Review> findAllByOrderByRatingDesc();

	

}
