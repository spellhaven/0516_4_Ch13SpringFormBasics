package com.spellhaven.spring0516_4;

public class MemberDto {
	
	// 주의할 점: 폼의 input type name들과 여기 변수 이름들이 같아야 한다. (순서는 상관없다.)
	// 이름으로 찾아서 데이터를 넣어 주는 원리기 때문. 그것이... Spring Framework니까
	
	private String id;
	private String name;
	private String pw;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
