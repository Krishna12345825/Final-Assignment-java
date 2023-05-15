package in.ineuron.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.UserDetails;


public interface IUserDetailsRepository extends JpaRepository<UserDetails, Integer> {
         public   Optional<UserDetails>   findByUname(String user);  //custom method
}
