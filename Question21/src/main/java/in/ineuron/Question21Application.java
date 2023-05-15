package in.ineuron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.ineuron.model.User;
import in.ineuron.repo.UserRepo;

@SpringBootApplication
public class Question21Application  implements CommandLineRunner{

	 @Autowired 
	 private UserRepo ob;
	 
	public static void main(String[] args) {
		SpringApplication.run(Question21Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 
		User first = new User(2, "Krishna Kumar");
        
		ob.save(first);
	}

}
