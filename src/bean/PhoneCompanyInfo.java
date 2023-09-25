package bean;

public class PhoneCompanyInfo extends PhoneInfo{
	private String company;
	
	public PhoneCompanyInfo(String name, String phoneNum, String company) {
		super(name, phoneNum);
		this.company=company;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("company: "+company);
		
	}

}
