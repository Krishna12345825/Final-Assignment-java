package in.ineuron.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
