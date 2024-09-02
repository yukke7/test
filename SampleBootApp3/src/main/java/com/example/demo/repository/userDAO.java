package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.entity.user;

@Component
public class userDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	/**
	 * ユーザ検索するメソッド
	 * @param userName
	 * @return
	 */
	public user searchByUserName(String name) {
		
		String query = "SELECT * FROM user WHERE name = ?";
		
		//SQL実行
		List<Map<String, Object>> ret = jdbc.queryForList(query, name);
		
		return getUser(ret);
	}
	
	public user getUser(List<Map<String, Object>> ret) {
		user u = new user();
		
		for(int i = 0; i < ret.size(); i++) {
			u.setName((String) ret.get(i).get("name"));
			u.setPass((String)ret.get(i).get("password"));
		}
		
		return u;
	}
}
