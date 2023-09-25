package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import bean.PhoneInfo;
import exception.MenuWrongException;

public class PhoneBook {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager();

		while (true) {
			try {
				showMenu();
				int menuNum = sc.nextInt(); // 1, 2, 10
				if(menuNum<0 || menuNum>5) {
					throw new MenuWrongException(menuNum);
				}
				switch (menuNum) {
				case 1:
					manager.inputData();
					break;
				case 2:
					manager.searchData();
					break;
				case 3:
					manager.deleteData();
					break;
				case 4:
					manager.showAllData();
					break;
				case 5:
					System.out.println("전화번호부가 종료되었다.");
					return; // main종료-->프로그램 종료
				}
			} catch (InputMismatchException e) {
				sc.nextLine();  //입력버퍼 삭제
				//System.out.println(e.getMessage());
				System.out.println("메뉴는 숫자로 입력하세요..");
				e.printStackTrace();
			} catch (MenuWrongException e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
				e.showWrongMenuNum();
				System.out.println("프로그램을 처음부터 다시 시작합니다..");
			}
		} // end while
	} // end main

	private static void showMenu() {
		System.out.println("메뉴를 선택하세요.");
		System.out.println("----------------");
		System.out.println(" 1.데이터 입력 ");
		System.out.println(" 2.데이터 검색 ");
		System.out.println(" 3.데이터 삭제 ");
		System.out.println(" 4.데이터 전체출력 ");
		System.out.println(" 5.프로그램 종료 ");
		System.out.println("----------------");
		System.out.print("선택: ");
	}
} // end class
