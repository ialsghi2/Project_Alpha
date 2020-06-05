package jsp.member.model;

import java.sql.Timestamp;


/**
 * 데이터의 전달을 담당하는 클래스 - DTO
 *<pre>
 * String id;	// 아이디
 * String password; // 비밀번호
 * String name;	// 이름
 * String gender;	// 성별
 * String birthyy;	// 생일 - 년
 * String birthmm;	// 생일 - 월
 * String birthdd;	// 생일 - 일
 * String mail1;	// 이메일 - @ 앞부분
 * String mail2;	// 이메일 - @ 뒷부분
 * String phone;	// 전화
 * String address;	// 주소
 * Timestamp reg;	// 가입일
 *</pre>
 */
public class MemberBean 
{
	private String id;			// 아이디
	private String password; 	// 비밀번호
	private String name;		// 이름
	private String gender;		// 성별
	private String birthyy;		// 생일 - 년
	private String birthmm;		// 생일 - 월
	private String birthdd;		// 생일 - 일
	private String mail1;		// 이메일 - @ 앞부분
	private String mail2;		// 이메일 - @ 뒷부분
	private String phone;		// 전화
	private String address;		// 주소
	private Timestamp reg;		// 가입일
	
	
	
	public MemberBean() {
		super();
		System.out.println("MemberBean() 객체 생성");
	}
	
	
	
	public MemberBean(String id, String password, String name, String gender, String birthyy, String birthmm,
			String birthdd, String mail1, String mail2, String phone, String address, Timestamp reg) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birthyy = birthyy;
		this.birthmm = birthmm;
		this.birthdd = birthdd;
		this.mail1 = mail1;
		this.mail2 = mail2;
		this.phone = phone;
		this.address = address;
		this.reg = reg;
		System.out.println("MemberBean(id,password,name,gender,birthyy,birthmm,birthdd,mail1,mail2,phone,address,reg)객체 생성");
	}



	public String getId() {
		System.out.println("getid() 호출");
		return id;
	}



	public void setId(String id) {
		System.out.println("setid(" + id + ") 호출");
		this.id = id;
	}



	public String getPassword() {
		System.out.println("getPassword() 호출");
		return password;
	}



	public void setPassword(String password) {
		System.out.println("setPassword(" + password + ") 호출");
		this.password = password;
	}



	public String getName() {
		System.out.println("getName() 호출");
		return name;
	}



	public void setName(String name) {
		System.out.println("setName(" + name + ") 호출");
		this.name = name;
	}



	public String getGender() {
		System.out.println("getGender() 호출");
		return gender;
	}



	public void setGender(String gender) {
		System.out.println("setGender(" + gender + ") 호출");
		this.gender = gender;
	}



	public String getBirthyy() {
		System.out.println("getBirthyy() 호출");
		return birthyy;
	}



	public void setBirthyy(String birthyy) {
		System.out.println("setBirthyy(" + birthyy + ") 호출");
		this.birthyy = birthyy;
	}



	public String getBirthmm() {
		System.out.println("getBirthmm() 호출");
		return birthmm;
	}



	public void setBirthmm(String birthmm) {
		System.out.println("setBirthmm(" + birthmm + ") 호출");
		this.birthmm = birthmm;
	}



	public String getBirthdd() {
		System.out.println("getBirthdd() 호출");
		return birthdd;
	}



	public void setBirthdd(String birthdd) {
		System.out.println("setBirthdd(" + birthdd + ") 호출");
		this.birthdd = birthdd;
	}



	public String getMail1() {
		System.out.println("getMail1() 호출");
		return mail1;
	}



	public void setMail1(String mail1) {
		System.out.println("setMail1" + mail1 + ") 호출");
		this.mail1 = mail1;
	}



	public String getMail2() {
		System.out.println("getMail2() 호출");
		return mail2;
	}



	public void setMail2(String mail2) {
		System.out.println("setMail2(" + mail2 + ") 호출");
		this.mail2 = mail2;
	}



	public String getPhone() {
		System.out.println("getPhone() 호출");
		return phone;
	}



	public void setPhone(String phone) {
		System.out.println("setPhone(" + phone + ") 호출");
		this.phone = phone;
	}



	public String getAddress() {
		System.out.println("getAddress() 호출");
		return address;
	}



	public void setAddress(String address) {
		System.out.println("setAddress(" + address + ") 호출");
		this.address = address;
	}



	public Timestamp getReg() {
		System.out.println("getReg() 호출");
		return reg;
	}



	public void setReg(Timestamp reg) {
		System.out.println("setReg(" + reg + ") 호출");
		this.reg = reg;
	}



	
}
