package jsp.board.model;
 
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import jsp.common.util.D;
import jsp.visit.model.VisitCountDAO;
 
 
public class BoardDAO 
{
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	/**
	 * String -> java.sql.Date로 변경하는 메서드
	 * 
	 * <pre>
	 * 문자열로된 생년월일을 Date로 변경하기 위해 필요하다.
	 * java.util.Date클래스로는 오라클의 Date형식과 연동할 수 없다.
	 * Oracle의 date형식과 연동되는 java의 Date는 java.sql.Date 클래스이다.
	 * </pre>
	 * 
	 * @param member 회원정보를 담고있는 TO
	 * @return java.sql.Date
	 */

	public BoardDAO() {
		
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("BoardDAO 생성, 데이터 베이스 연결!");
		} catch(Exception e) {
			e.printStackTrace();
			// throw e;
		}		
		
	} // 생성
	
	public void close() throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}
	

   public int insert(BoardBean dto) throws SQLException {
	   String id = dto.getId();
	   String subject = dto.getSubject();
	   String content = dto.getContent();
	   
	   int cnt=this.insert(id,subject,content);
	   return cnt;
   }
   
   public int insert(String id,String subject, String content) throws SQLException {
	   int cnt=0;
	   
	   try {
		   pstmt=conn.prepareStatement(D.SQL_BOARD_INSERT);
		   pstmt.setString(1, id);
		   pstmt.setString(2, subject);
		   pstmt.setString(3, content);
		   
		   cnt= pstmt.executeUpdate();
				   
	   } finally {
		   close();
	   }
	   
	   return cnt;
   }


    public BoardBean[] createArray(ResultSet rs) throws SQLException {
    	BoardBean [] arr = null;
    	
    	ArrayList<BoardBean> list = new ArrayList<BoardBean>();
    	
    	while(rs.next()) {
    		int num=rs.getInt("board_num");         
		    String id=rs.getString("id");       
		    String subject=rs.getString("board_subject");     
		    String content=rs.getString("board_content");     
		    int count=rs.getInt("board_count");         
		    Date d=rs.getDate("board_date");
		    Time t=rs.getTime("board_date");
		    
		    String date="";
		    if(d!=null) {
		    	date = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
		    			+ new SimpleDateFormat("hh:mm:ss").format(t);
		    }
		    
		    BoardBean dto = new BoardBean(num,id,subject,content,count);
		    dto.setDate(date);
		    list.add(dto);
		    
    	}//end while
    	
    	int size = list.size();
    	
    	if(size == 0) return null;
    	
    	arr = new BoardBean[size];
    	list.toArray(arr);
    	return arr;
    	
    }
    
    public BoardBean [] select() throws SQLException {
    	BoardBean [] arr = null;
    
    	try {
    		pstmt = conn.prepareStatement(D.SQL_BOARD_SELECT);
    		rs=pstmt.executeQuery();
    		arr=createArray(rs);
    		
    	} finally {
    		close();
    	}
    	
    	return arr;
    }
    
    public BoardBean [] readByNum(int num) throws SQLException{
		int cnt = 0;
		BoardBean [] arr = null;
		
		try {
			// 트랜잭션 처리
			// Auto-commit 비활성화
			conn.setAutoCommit(false);
			
			// 쿼리들 수행
			pstmt = conn.prepareStatement(D.SQL_BOARD_COUNT);
			pstmt.setInt(1, num);
			cnt = pstmt.executeUpdate();
			
			pstmt.close();
			
			pstmt = conn.prepareStatement(D.SQL_BOARD_SELECT_BY_NUM);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			arr = createArray(rs);
			conn.commit();
			
		} catch(SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			close();
		}
		
		return arr;
	} // end readByUid()
	
	public BoardBean [] selectByNum(int num) throws SQLException {
		BoardBean [] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_BOARD_SELECT_BY_NUM);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		return arr;
	}
	
	public int update(int num, String subject, String content) throws SQLException {
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(D.SQL_BOARD_UPDATE);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}		
		
		return cnt;
	} // end update()
	
	// 특정 uid 글 삭제하기
	public int deleteByNum(int num) throws SQLException {
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(D.SQL_BOARD_DELETE_BY_NUM);
			pstmt.setInt(1, num);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}		
		return cnt;
	} // end deleteByUid()
	
	
	
 
}


