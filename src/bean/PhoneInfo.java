package bean;

public class PhoneInfo {
	private String name;
	private String phoneNum;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
   //생성자(필드값 초기용) 및 메소드 정의할것...
	//기본 생성자
	public PhoneInfo(String name, String phoneNum) {
		//this: 현재실행중인 객체 참조변수
		this.name=name;
		this.phoneNum=phoneNum;
	}
	
	public void showPhoneInfo() {
		System.out.println("name: "+name);
		System.out.println("phoneNum: "+this.phoneNum);
	}
	@Override
	public int hashCode() {
		return name.hashCode(); //이름이 같은인스턴스끼리 묶음
	}
	@Override
	public boolean equals(Object obj) {
		PhoneInfo cmp=(PhoneInfo)obj;
		if(name.equals(cmp.getName()))
			return true;
		return false;
	}
	
	
}
