package jsp.board.model;
 
 
public class BoardBean 
{
    private int num;          // 글번호
    private String id;         // 글 작성자
    private String subject;     // 글 제목
    private String content;     // 글 내용
    private int count;         // 글 조회수
    private String date;         // 글 작성일
    
    
    public BoardBean() {
    	super();
    	System.out.println("BoardBean() 객체 생성");
    }
    
    
    public BoardBean(int num, String id, String subject, String content, int count) {
		super();
		this.num = num;
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.count = count;
		System.out.println("BoardBean(num,id,subject,content,count) 객체 생성");
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
}


