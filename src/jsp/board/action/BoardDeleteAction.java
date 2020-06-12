package jsp.board.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.board.model.BoardDAO;
import jsp.common.action.Command;

public class BoardDeleteAction implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;

		BoardDAO dao = new BoardDAO();

		//입력한 값을 받아오기
		int num = Integer.parseInt(request.getParameter("num"));

		try {			
			cnt = dao.deleteByNum(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("result", cnt);

	}

}
