package jp.co.aforce.beans;

public class userBean {
	private String memberId1;
	private String password1;
	private String lastName1;
	private String firstName1;
	private String address1;
	private String mailAddress1;
	
	public userBean(String memberId1,String password1,String lastName1, String firstName1, String address1, String mailAddress1) {
		this.memberId1 = memberId1;
		this.password1 = password1;
		this.lastName1 = lastName1;
		this.firstName1 = firstName1;
		this.address1 = address1;
		this.mailAddress1 = mailAddress1;
		
	}
		
	public String getMemberId1() {
		return memberId1;
	}
	public void setMemberId1(String memberId1) {
		this.memberId1 = memberId1;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getLastName1() {
		return lastName1;
	}
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}
	public String getFirstName1() {
		return firstName1;
	}
	public void setFirstName1(String firstName1) {
		this.firstName1 = firstName1;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getMailAddress1() {
		return mailAddress1;
	}
	public void setMailAddress1(String mailAddress1) {
		this.mailAddress1 = mailAddress1;
	}

	
}
