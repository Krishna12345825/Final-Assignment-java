//IUserRegistrationService.java
package in.ineuron.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import in.ineuron.model.UserDetails;

public interface IUserRegistrationService extends  UserDetailsService{
   public  String registerUser(UserDetails details);
}
