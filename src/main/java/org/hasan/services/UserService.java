package org.hasan.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hasan.models.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service // this is a service layer class
// it is responsible to fetch | store | update | delete the user from and
// to the database
public class UserService 
{
	@Autowired // get the object from the bean factory
	@Qualifier("np1") // whose name is 'np1' 
	NamedParameterJdbcTemplate template;
	
	// this method will store the object of UserInfo inside database
	public int saveData(Userinfo userinfo)
	{
		String sql = "insert into userinfo(name, email, password) values"
				+ "(:u_name,:u_email,:u_pass)";
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("u_name",userinfo.getName());
		map.put("u_email",userinfo.getEmail());
		map.put("u_pass",userinfo.getPass());
		return template.update(sql, map);
	}

	// this method will update the object of UserInfo inside database
	public int updateUser(Userinfo userinfo)
	{
		String sql = "update userinfo set name=:u_name, password=:u_pass where email=:u_email";
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("u_name",userinfo.getName());
		map.put("u_email",userinfo.getEmail());
		map.put("u_pass",userinfo.getPass());
		return template.update(sql, map);
	}

	// this method will delete an object of UserInfo from database
	public int deleteUserByEmail(String email)
	{
		String sql = "delete from userinfo where email = :u_name";
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("u_name", email);
		return template.update(sql, map);
	}

	// this method will fetch a list of UserInfo from the database
	public List<Userinfo> getUserInfoList()
	{
		String sql = "select * from userinfo";
		return template.query(sql, new ImpRowMapper());
	}

	// this method will fetch a single object of UserInfo from the database
	// on the basis of the email
	public Userinfo getUserInfoByEmail(String u_email)
	{
		String sql = "select * from userinfo where email=:u_email";
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("u_email",u_email);
		return template.queryForObject(sql, map, new ImpRowMapper());
	}

	// this inner-class will be internally used by query() and queryForObject()
	// methods to fetch records from the database and then map those records 
	// as objects
	private class ImpRowMapper implements RowMapper<Userinfo>
	{
		@Override
		public Userinfo mapRow(ResultSet rs, int cols) throws SQLException 
		{
			return new Userinfo(rs.getString("name"), rs.getString("email"), rs.getString
					("password"));
		}		
	}
}