package in.ineuron.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}