package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.user;
import com.example.demo.repository.userDAO;

@Service
public class userDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private userDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user ur = dao.searchByUserName(username);
		if(ur == null) {
			throw new UsernameNotFoundException("not found :" + username);
		}
		
		return new customerUserDetails(ur);
	}

}
