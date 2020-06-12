package jsp.board.action;
 
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import jsp.common.action.Command;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BoardController() {
    	super();
    }
 
    /**
     * GET 방식일 경우 doGet()
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            doProcess(request,response);
    }      
        
    /**
     * POST 방식일 경우 doPost()
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            doProcess(request,response);
    }
 
    /**
     * 명령어에 따른 해당 Action을 지정해 준다.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doProcess(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
		System.out.println("doProcess() 호출");
		
		request.setCharacterEncoding("UTF-8");
    	
		String viewPage = null;
		Command command = null;
		
	
		String uri =request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		System.out.println("uri: " + uri);
		System.out.println("conPath: " + conPath);
		System.out.println("com: " + com);

        switch(com) {
        
        case "/BoardListForm.bo":
        	command = new BoardListAction();
        	command.execute(request, response);
        	viewPage = "BoardListForm.jsp";
        	break;
        	
        case "/BoardWriteForm.bo":
        	viewPage = "BoardWriteForm.jsp";
        	break;
        	
        case "/BoardWriteOk.bo":
        	command = new BoardWriteAction();
        	command.execute(request, response);
        	viewPage = "BoardWriteOk.jsp";
        	break;
        
        case "/BoardViewForm.bo":
        	command = new BoardViewAction();
        	command.execute(request, response);
        	viewPage = "BoardViewForm.jsp";
        	break;
        	
        case "/BoardUpdateForm.bo":
        	command = new BoardSelectAction();
        	command.execute(request, response);
        	viewPage = "BoardUpdateForm.jsp";
        	break;
        	
        case "/BoardUpdateOk.bo":
        	command = new BoardUpdateAction();
        	command.execute(request, response);
        	viewPage = "BoardUpdateOk.jsp";
        	break;
        	
        case "/BoardDeleteOk.bo":
        	command = new BoardDeleteAction();
        	command.execute(request, response);
        	viewPage = "BoardDeleteOk.jsp";
        	break;
        	
        }
        	
        	
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
		
        
     
    } // end doProcess                    
}
 


