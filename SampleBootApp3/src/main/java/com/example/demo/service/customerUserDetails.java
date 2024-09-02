package com.example.demo.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.entity.user;
/**
 * ユーザ情報を保持するクラス
 */
@Service
public class customerUserDetails implements UserDetails{
	
	//自分で作成したuserをフィールドに持たせる
	private final user ur;
	
	public customerUserDetails(user ur) {
		this.ur = ur;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return this.ur.getPass();
	}

	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return this.ur.getName();
	}

}
