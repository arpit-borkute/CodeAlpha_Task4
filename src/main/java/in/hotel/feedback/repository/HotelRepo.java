package in.hotel.feedback.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.hotel.feedback.entity.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {

	List<Hotel> findByName(String name);

	 
}
