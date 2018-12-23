package com.ipping.demo.security.service;



import com.ipping.demo.model.User;
import com.ipping.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

	private final UserService userService;

	@Autowired
	public AuthenticationService(UserService userService) {
		this.userService = userService;
	}

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.getByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Username " + email + " not found");
		}
		return user;
	}
}
