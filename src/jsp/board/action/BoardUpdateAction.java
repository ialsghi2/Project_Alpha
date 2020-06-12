package jsp.board.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.board.model.BoardDAO;
import jsp.common.action.Command;

public class BoardUpdateAction implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;

		BoardDAO dao = new BoardDAO();

		//입력한 값을 받아오기
		int num = Integer.parseInt(request.getParameter("num"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		// 유효성 체크  null 이거나, 빈문자열이면 이전화면으로 돌아가기
		if(subject != null && subject.trim().length() > 0){			
			try {			
				cnt = dao.update(num, subject, content);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // end if

		request.setAttribute("result", cnt);

	}

}
