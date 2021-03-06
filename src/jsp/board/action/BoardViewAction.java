package jsp.board.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.board.model.BoardBean;
import jsp.board.model.BoardDAO;
import jsp.common.action.Command;

public class BoardViewAction implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = new BoardDAO();
		BoardBean [] arr = null;
		int num = Integer.parseInt(request.getParameter("num"));

		try {
			arr = dao.readByNum(num);// 읽기 + 조회수 증가
			request.setAttribute("list", arr);
		} catch (SQLException e) { // 만약 ConnectionPool 을 사용한다면 여기서 NamingException 도 catch 해야 한다  
			e.printStackTrace();
		}
	}

}
