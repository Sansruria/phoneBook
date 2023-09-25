package exception;
//예외클래스 정의
public class MenuWrongException extends Exception{
	private int wrongNum;  //인스턴스 변수
	
	public MenuWrongException(int wrongNum) {
		super("번호는 오류입니다.");  //getMassage()
		this.wrongNum=wrongNum;  //인스턴스변수 초기화
	}
	public void showWrongMenuNum() {
		System.out.println(wrongNum+"번호는 존재하지 않아요");
	}
}
