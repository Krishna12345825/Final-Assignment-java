package in.ineuron.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Order;
import in.ineuron.model.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByUser(User user);

}
