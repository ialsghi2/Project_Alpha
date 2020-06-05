package jsp.board.model;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jsp.common.util.D;
 
 
public class BoardDAO 
{
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 
	/**
	 * String -> java.sql.Date로 변경하는 메서드
	 * <pre>
	 * 문자열로된 생년월일을 Date로 변경하기 위해 필요하다.
	 * java.util.Date클래스로는 오라클의 Date형식과 연동할 수 없다.
	 * Oracle의 date형식과 연동되는 java의 Date는 java.sql.Date 클래스이다. </pre>
	 * @param member 회원정보를 담고있는 TO
	 * @return java.sql.Date
	 */
	
	public BoardDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("WriteDAO 생성, 데이터 베이스 연결!");
		} catch(Exception e) {
			e.printStackTrace();
			// throw e;
		}	
	}
	
	public void close() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
    // 시퀀스를 가져온다.
    public int getSeq() throws SQLException
    {
        int result = 1;
        
        try {
            
            // 시퀀스 값을 가져온다. (DUAL : 시퀀스 값을 가져오기위한 임시 테이블)
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT BOARD_NUM.NEXTVAL FROM DUAL");
            
            pstmt = conn.prepareStatement(sql.toString());
            // 쿼리 실행
            rs = pstmt.executeQuery();
            
            if(rs.next())    result = rs.getInt(1);
 
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        
		close();
		
        return result;    
    } // end getSeq
    
    // 글 삽입
    public boolean boardInsert(BoardBean board) throws SQLException
    {
        boolean result = false;
        
        try {
            
            StringBuffer sql = new StringBuffer();
            sql.append("INSERT INTO MEMBER_BOARD");
            sql.append("(BOARD_NUM, BOARD_ID, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE");
            sql.append(", BOARD_COUNT, BOARD_DATE)");
            sql.append(" VALUES(?,?,?,?,?,?,sysdate)");
 
            // 시퀀스 값을 글번호와 그룹번호로 사용
            int num = board.getBoard_num();
 
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, num);
            pstmt.setString(2, board.getBoard_id());
            pstmt.setString(3, board.getBoard_subject());
            pstmt.setString(4, board.getBoard_content());
            pstmt.setString(5, board.getBoard_file());
            pstmt.setInt(6, num);
 
            
            int flag = pstmt.executeUpdate();
            if(flag > 0){
               result = true;
               conn.commit(); 
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        close();
        
        return result;    
    } // end boardInsert();
    
    // DB 자원해제
 
}


