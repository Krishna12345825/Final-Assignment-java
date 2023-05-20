package in.ineuron.controller;


import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/ticket")
public class TicketBookingController {

	@GetMapping("/booking")
	
	@HystrixCommand(fallbackMethod = "dummyBookTickets",
                                                commandProperties = { @HystrixProperty(name="circuitBreaker.enabled", value="true"),
                                                		                                        @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="5"),
                                                		                                        @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="7000")
                                                                                            }
	                                      )
	
	public  String   bookTickets() {
		System.out.println("TicketBookingController.bookTickets()");
		if(new Random().nextInt(10)<7) 
			throw new IllegalArgumentException("problem in ticket bookig");
			
			return "<b>Tickets booked sucessfully</b>";
		}
	
	int count=0;
	public  String dummyBookTickets() {   
		 count++;
		System.out.println("TicketBookingController.dummyBookTickets()::"+count);
		return " Sorry for inconvience .... some problem in ticket booking";
	}
	
}
	