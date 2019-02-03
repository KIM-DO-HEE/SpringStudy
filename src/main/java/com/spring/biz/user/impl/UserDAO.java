package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;
import com.spring.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO{
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET = "select * from users where id =? and pw = ?";
	
	/* (non-Javadoc)
	 * @see com.spring.biz.user.impl.UserService#getUser(com.spring.biz.user.UserVO)
	 */
	public UserVO getUser(UserVO vo) {
		System.out.println("===> getUser()");
		UserVO user = null;
		try {
			System.out.println("===> JDBC로 getUser() 기능 처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPw());
			rs = stmt.executeQuery();
			System.out.println("rs"+rs);
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPw(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				System.out.println("user"+user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return user;
	}
			
}
