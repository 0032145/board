package com.board.bdi.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID="bdi";
	private static final String PWD="12345678";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public Map<String, String> selectUser(Map<String, String> user) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "select * from user_info where ui_id=? and ui_pwd=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("uiId"));
			ps.setString(2, user.get("uiPwd"));
			rs = ps.executeQuery();
			if(rs.next()) {
				user.put("uiNum", rs.getString("ui_num"));
				user.put("uiName", rs.getString("ui_name"));
				user.put("credat", rs.getString("credat"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Map<String, String>> selectUserList(Map<String, String> user) {
		List<Map<String, String>> userList = new ArrayList<>();
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "select * from user_info where 1=1 ";
			if(user.get("uiId")!=null) {
				sql += "and uiId=? ";
			}
			if(user.get("uiNum")!=null) {
				sql += "and uiNum=? ";
			}
			if(user.get("uiName")!=null) {
				sql += "and uiName=? ";
			}
			sql += " order by ui_num desc ";
			ps = con.prepareStatement(sql);
			if(user.get("uiId")!=null&&user.get("uiNum")==null&&user.get("uiName")==null) {
				ps.setString(1,user.get("uiId"));
			} else if(user.get("uiId")==null&&user.get("uiNum")!=null&&user.get("uiName")==null) {
				ps.setString(1,user.get("uiNum"));
			} else if(user.get("uiId")==null&&user.get("uiNum")==null&&user.get("uiName")!=null) {
				ps.setString(1,user.get("uiName"));
			} else if(user.get("uiId")!=null&&user.get("uiNum")!=null&&user.get("uiName")==null) {
				ps.setString(1,user.get("uiId"));
				ps.setString(2,user.get("uiNum"));
			} else if(user.get("uiId")!=null&&user.get("uiNum")==null&&user.get("uiName")!=null) {
				ps.setString(1,user.get("uiId"));
				ps.setString(2,user.get("uiName"));
			} else if(user.get("uiId")==null&&user.get("uiNum")!=null&&user.get("uiName")!=null) {
				ps.setString(1,user.get("uiNum"));
				ps.setString(2,user.get("uiName"));
			} else if(user.get("uiId")!=null&&user.get("uiNum")!=null&&user.get("uiName")!=null){
				ps.setString(1,user.get("uiId"));
				ps.setString(2,user.get("uiNum"));
				ps.setString(3,user.get("uiName"));
			}
			rs = ps.executeQuery(); 
			while(rs.next()) {
				Map<String, String> u = new HashMap<>();
				u.put("uiNum", rs.getString("ui_num"));
				u.put("uiId", rs.getString("ui_id"));
				u.put("uiName", rs.getString("ui_name"));
				u.put("cretim", rs.getString("cretim"));
				u.put("moddat", rs.getString("moddat"));
				u.put("modtim", rs.getString("modtim"));
				u.put("active", rs.getString("active"));
				u.put("credat", rs.getString("credat"));
				userList.add(u);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return null;
	}
}