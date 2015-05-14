package org.fpt.persistence.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.fpt.persistence.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class fetches the user's information from form
 * and populates the {@link User} object with it.
 *
 */

@Service("userDetailsService")
public class LoginService implements UserDetailsService {
	
	@Autowired
	private IUserDao userDao;
	
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
 
		org.fpt.persistence.models.User user = userDao.findUserByUsername(username);
		
		System.out.println(user);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
 
		return buildUserForAuthentication(user, authorities);
	}
	
	// Converts local User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(org.fpt.persistence.models.User user, List<GrantedAuthority> authorities) {
		return new User(user.getEmail(), user.getPassword(), true, true, true, true, authorities);
	}
	 
	private List<GrantedAuthority> buildUserAuthority(String userRole) {
	 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
	 
		// Build user's authorities
		setAuths.add(new SimpleGrantedAuthority(userRole));
		
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
	 
		return Result;
	}
	
}