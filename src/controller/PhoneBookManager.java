package controller;

import java.util.HashSet;
import java.util.Iterator;

import bean.PhoneCompanyInfo;
import bean.PhoneInfo;
import bean.PhoneUnivInfo;
import exception.MenuWrongException;

public class PhoneBookManager {
	//private final int MAX = 100;
	//private PhoneInfo[] phoneList = new PhoneInfo[MAX];
	//private int cnt = 0;
	HashSet<PhoneInfo> phoneList=new HashSet<PhoneInfo>();
	//ArrayList<PhoneInfo> list=new ArrayList<PhoneInfo>();
	
	public void inputData() throws MenuWrongException {
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1.일반, 2.대학, 3.회사");
		System.out.print("선택>> ");
		int subMenu=PhoneBook.sc.nextInt();
		
		if(subMenu<0 || subMenu>3) {
			throw new MenuWrongException(subMenu);
		}
		PhoneInfo info=null;
		switch(subMenu) {
		case 1:
			info=normalInput();
			break;
		case 2:
			info=univInput();
			break;
		case 3:
			info=companyInput();
			break;
		}
		//phoneList[cnt++] = info;
		boolean isAdd=phoneList.add(info);
		if(isAdd) {
			System.out.println("입력 성공");
		}else {
			System.out.println("이미 저장된 데이터입니다.");
		}
	}
	private PhoneInfo companyInput() {
		System.out.println("데이터 입력을 합니다.");
		System.out.print("이름: ");
		String name = PhoneBook.sc.next();
		System.out.print("전화번호: ");
		String phoneNum = PhoneBook.sc.next(); // 11111엔터
		System.out.print("회사: ");
		String company = PhoneBook.sc.next();
		return new PhoneCompanyInfo(name, phoneNum, company);
	}
	private PhoneInfo normalInput() {
		System.out.println("데이터 입력을 합니다.");
		System.out.print("이름: ");
		String name = PhoneBook.sc.next();
		System.out.print("전화번호: ");
		String phoneNum = PhoneBook.sc.next(); // 11111엔터
		return new PhoneInfo(name, phoneNum);
	}
	private PhoneInfo univInput() {
		System.out.println("데이터 입력을 합니다.");
		System.out.print("이름: ");
		String name = PhoneBook.sc.next();
		System.out.print("전화번호: ");
		String phoneNum = PhoneBook.sc.next(); // 11111엔터
		System.out.print("전공: ");
		String major = PhoneBook.sc.next();
		System.out.print("학년: ");
		int year = PhoneBook.sc.nextInt(); // 11111엔터
		return new PhoneUnivInfo(name, phoneNum, major, year);
	}
	
	public void searchData() {
		System.out.println("데이터 검색을 합니다.");
		System.out.print("이름: ");
		String name = PhoneBook.sc.next();

		/*int idx = searchIdx(name); // 이름존재하면 해당 인덱스 반환 , 아니면 -1반환

		if (idx == -1) {
			System.out.println("검색할 데이터가 존재하지 않습니다!!");
			// return;
		} else {
			phoneList[idx].showPhoneInfo();
			System.out.println("검색 완료!!!");
		}*/
//		for(int i=0;i<cnt;i++) {
//			if(name.equals(phoneList[i].getName())) {
//				phoneList[i].showPhoneInfo();
//				System.out.println("검색 완료!!!");
//				return;
//			}
//		}//end for
		// System.out.println("검색할 데이터가 존재하지 않습니다!!");
		
		PhoneInfo info=search(name);
		if(info==null) {
			System.out.println("해당 데이터가 존재하지 않습니다.");
		}else {
			info.showPhoneInfo();
			System.out.println("데이터 검색 완료!!");
		}
	}  //end searchData

	private PhoneInfo search(String name) {
		Iterator<PhoneInfo> itr=phoneList.iterator();
		while(itr.hasNext()) {
			PhoneInfo curInfo=itr.next();
			if(name.equals(curInfo.getName())) {
				//itr.remove(); //삭제
				return curInfo;
			}
		}
		return null;  //검색 실패
	}
	public void deleteData() {
		System.out.println("데이터 삭제를 합니다.");
		System.out.print("이름: ");
		String name = PhoneBook.sc.next();
		
		/*int idx = searchIdx(name); // 이름존재하면 해당 인덱스 반환 , 아니면 -1반환

		if (idx == -1) {
			System.out.println("삭제할 데이터가 존재하지 않습니다!!");
			// return;
		} else {
			phoneList[idx]=phoneList[cnt-1];
			cnt--;
			System.out.println("삭제 완료!!!");
		}*/

//		for(int i=0;i<cnt;i++) {
//			if(name.equals(phoneList[i].getName())) {
//				phoneList[i]=phoneList[cnt-1];
//				cnt--;
//				System.out.println("삭제 완료!!!");
//				return;
//			}
//		}//end for
//		System.out.println("삭제할 데이터가 존재하지 않습니다!!");
		PhoneInfo info=search(name);
		if(info==null) {
			System.out.println("해당 데이터가 존재하지 않습니다.");
		}else {
			phoneList.remove(info);
			System.out.println("데이터 삭제 완료!!");
		}
	}//end deleteData
	/*private int searchIdx(String name) {
		for (int i = 0; i < cnt; i++) {
			if(name.equals(phoneList[i].getName())) {
				return i;
			}
		}
		return -1;  //에러
	}*/

	public void showAllData() {
		System.out.println("전체 리스트 출력");
//		for(PhoneInfo info: phoneList) {
//			info.showPhoneInfo();
//		}
//		for (int i = 0; i < cnt; i++) {
//			phoneList[i].showPhoneInfo();
//			System.out.println("----------------");
//		}
		Iterator<PhoneInfo> itr=phoneList.iterator();
		while(itr.hasNext()) {
			itr.next().showPhoneInfo();
			System.out.println("---------------");
		}
	}
} // end class
