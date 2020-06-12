package jsp.common.util;


public class D {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USERID = "scott9302";
	public static final String USERPW = "tiger9302";
	
	public static final String SQL_BOARD_SELECT =
			"SELECT * FROM jsp_member_board ORDER BY board_num DESC";
	
	public static final String SQL_BOARD_INSERT = "INSERT INTO jsp_member_board" +
   "(board_num,id,board_subject,board_content)" +
    " VALUES(jsp_member_board_seq.nextval, ?, ?, ?)";
	
	public static final String SQL_BOARD_COUNT = //조회수 증가
			"UPDATE jsp_member_board SET board_count = board_count + 1 WHERE board_num= ?";

	public static final String SQL_BOARD_SELECT_BY_NUM = //글 읽어오기
			"SELECT * FROM jsp_member_board WHERE board_num = ?";
	
	public static final String SQL_BOARD_UPDATE =
			"UPDATE jsp_member_board SET board_subject = ?, board_content = ? WHERE board_num = ?";
	
	public static final String SQL_BOARD_DELETE_BY_NUM =
			"DELETE FROM jsp_member_board WHERE board_num = ?";

}	

