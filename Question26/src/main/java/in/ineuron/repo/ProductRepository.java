package in.ineuron.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
