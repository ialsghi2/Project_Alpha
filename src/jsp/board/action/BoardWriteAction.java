package jsp.board.action;
 
import java.sql.SQLException;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.board.model.BoardDAO;
import jsp.common.action.Command;
 
public class BoardWriteAction implements Command {
 

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int cnt=0;
		BoardDAO dao = new BoardDAO();
		
		String id = request.getParameter("id");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		if(subject!=null && subject.trim().length()>0) {
			
			try {
				cnt=dao.insert(id,subject,content);
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}//end if
		
		request.setAttribute("result", cnt);
		
	}
	
}
 


