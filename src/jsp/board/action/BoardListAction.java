package jsp.board.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.board.model.BoardBean;
import jsp.board.model.BoardDAO;
import jsp.common.action.Command;

public class BoardListAction implements Command
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao =new BoardDAO();
		BoardBean [] arr = null;
		
		
		try {
			arr=dao.select();
			
			request.setAttribute("list", arr);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	
		
		
		
	}

}
