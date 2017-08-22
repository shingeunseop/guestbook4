package com.guestbook.repository;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guestbook.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;

	public int insert(GuestbookVo vo) {
		
		return sqlSession.insert("guestbook.insert",vo);
	}

	public List<GuestbookVo> getList() {
		List<GuestbookVo> list=sqlSession.selectList("guestbook.getList");
		
		return list;

}
	/*public int delete(int no,String password) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url,"webdb","webdb");
			System.out.println("접속성공");
			
			String query="delete from guestbooks "
					+"where password=? "
					+"and no=?";
			
			pstmt=conn.prepareStatement(query);
			
			pstmt.setInt(2, no);
			pstmt.setString(1, password);
			
			pstmt.executeQuery();
			
		}catch(ClassNotFoundException e) {
			System.out.println("error:드라이벌딩 실패."+e);
		}catch(SQLException e) {
			System.out.println("error"+e);
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println("error:"+e);
			}

	}
		return 0;
		
	}*/
}