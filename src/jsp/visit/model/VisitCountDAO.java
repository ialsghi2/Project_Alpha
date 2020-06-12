package jsp.visit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jsp.common.util.D;
import jsp.member.model.MemberDAO;

public class VisitCountDAO {
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

	public VisitCountDAO() {	
		
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("VisitCountDAO 생성, 데이터 베이스 연결!");
		} catch(Exception e) {
			e.printStackTrace();
			// throw e;
		}		
		
	} 

	public void setTotalCount() throws SQLException {
		try {
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO VISIT (V_DATE) VALUES (sysdate)");
			
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql.toString());
			// 쿼리 실행
			pstmt.executeUpdate();
			// 완료시 커밋
			conn.commit(); 
			
		} catch ( Exception sqle) {
			try {
				conn.rollback(); // 오류시 롤백
			} catch (SQLException e) {
				e.printStackTrace();
			}
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try{
				if ( pstmt != null ){ pstmt.close(); pstmt=null; }
				if ( conn != null ){ conn.close(); conn=null;	}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}

	}
	
	public int getTotalCount() {
		
        int totalCount = 0;

		try {
			StringBuffer sql = new StringBuffer();
            sql.append("SELECT COUNT(*) AS TotalCnt FROM VISIT");

            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            
            // 방문자 수를 변수에 담는다.
            if (rs.next()) 
                totalCount = rs.getInt("TotalCnt");
            
            return totalCount;
				
		} catch (Exception sqle) {
            throw new RuntimeException(sqle.getMessage());
        } finally {
            // Connection, PreparedStatement를 닫는다.
            try{
                if ( pstmt != null ){ pstmt.close(); pstmt=null; }
                if ( conn != null ){ conn.close(); conn=null;    }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }

	}
	
	public int getTodayCount() {
		
		int todayCount = 0;
		
		try {
			  StringBuffer sql = new StringBuffer();
	            sql.append("SELECT COUNT(*) AS TodayCnt FROM VISIT");
	            sql.append(" WHERE TO_DATE(V_DATE, 'YYYY-MM-DD') = TO_DATE(sysdate, 'YYYY-MM-DD')");
	            
	            pstmt = conn.prepareStatement(sql.toString());
	            rs = pstmt.executeQuery();
	            
	            // 방문자 수를 변수에 담는다.
	            if (rs.next()) 
	                todayCount = rs.getInt("TodayCnt");
	            
	            return todayCount;

		} catch (Exception sqle) {
            throw new RuntimeException(sqle.getMessage());
        } finally {
            // Connection, PreparedStatement를 닫는다.
            try{
                if ( pstmt != null ){ pstmt.close(); pstmt=null; }
                if ( conn != null ){ conn.close(); conn=null;    }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }

	}
	
}//end VisitCountDAO
