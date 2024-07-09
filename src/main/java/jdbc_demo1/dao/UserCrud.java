package jdbc_demo1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc_demo1.dto.User;
public class UserCrud {
	public void saveTable() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy?createDatabaseIfNotExist=true", "root", "root");
		PreparedStatement ps = con.prepareStatement("create table if not exists drone(id int primary key,name varchar(45),phone bigint,email varchar(45),pwd varchar(45))");
		ps.execute();
		ps.close();
		con.close();
	}
	
	public void saveData(User user) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy?createDatabaseIfNotExist=true", "root", "root");
		PreparedStatement ps = con.prepareStatement("insert into drone values(?,?,?,?,?)");
		ps.setInt(1,user.getId());
		ps.setString(2,user.getName());
		ps.setLong(3,user.getPhone());
		ps.setString(4,user.getEmail());
		ps.setString(5,user.getPwd());
		ps.execute();
		ps.close();
		con.close();
	}
	
	public void updateUser(User user) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy?createDatabaseIfNotExist=true", "root", "root");
		PreparedStatement ps = con.prepareStatement("update drone set name=?,pwd=? where phone=? and email=?");
		ps.setString(1,user.getName());
		ps.setString(2,user.getPwd());
		ps.setLong(3, user.getPhone());
		ps.setString(4,user.getEmail());
		ps.execute();
		ps.close();
		con.close();
	}
	
	public void fetchUser(long phone,String email) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy?createDatabaseIfNotExist=true", "root", "root");
		PreparedStatement ps = con.prepareStatement("select * from drone where phone=? and email=?");
		ps.setLong(1, phone);
		ps.setString(2,email);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("id:"+rs.getInt(1)+",name:"+rs.getString(2)+",phone:"+rs.getLong(3)+",email:"+rs.getString(4)+",pwd:"+rs.getString(5));
		}
		ps.close();
		con.close();
	}
}
