package in.ineuron.service;


import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.ineuron.model.UserDetails;
import in.ineuron.repository.IUserDetailsRepository;

@Service("userService")
public abstract class UserRegistrationServiceImpl implements IUserRegistrationService {
	@Autowired
	private IUserDetailsRepository  userRepo;
	@Autowired
	private BCryptPasswordEncoder  encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//use  userRepo to get currently logged in user details in the form of UserDetails obj
		Optional<UserDetails> opt=userRepo.findByUname(username);
		if(opt.isEmpty())
			throw new IllegalArgumentException("User not found");
		else {
			  in.ineuron.model.UserDetails details=opt.get();
		/*	// convert Set<String> oles to  Set<SGA> roles
			    Set<GrantedAuthority>  SGARoles=new HashSet();
			   for(String role: details.getRoles()) {
				    SimpleGrantedAuthority  sga=new SimpleGrantedAuthority(role);
				    SGARoles.add(sga);
			   }//for
			   //convert Model UserDetails obj to  User obj
			   User user=new User(details.getUname(),details.getPwd(),SGARoles);
			   return user;*/
			 User user=new User(details.getUname(),
					                                   details.getPwd(),
					                                   details.getRoles().stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
			 System.out.println(user.getAuthorities().toString());
			 System.out.println(user);
			 return user;
		}//else
	}

	@Override
	public String registerUser(in.ineuron.model details) {
		  // Encode the Password
		  details.setPwd(encoder.encode(details.getPwd()));
		  // save object
		  return "user is registered with"+ userRepo.save(details).getUnid()+" id value";
		
	}

}
