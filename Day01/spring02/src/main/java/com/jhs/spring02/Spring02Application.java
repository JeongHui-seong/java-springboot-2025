package com.jhs.spring02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner; // 콘솔 입력받을 클래스 선언

@SpringBootApplication
public class Spring02Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring02Application.class, args);

		Scanner scan = new Scanner(System.in);
		
		System.out.print(">> 아이디 입력 : ");
		String userid = scan.next();
		System.out.print(">> 비밀번호 입력 : ");
		String passwd = scan.next();

		System.out.println("입력 아이디 --> " + userid);
		System.out.println("입력 비밀번호 --> " + passwd);

		// if문 연습
		if (userid.equals("zzreal") && passwd.equals("zzreal")){
			System.out.println(userid + "님 반갑슴다");
		} else {
			System.out.println("로그인 실패");
		}

		// switch문 연습
		switch(passwd){
			case "12345":
				System.out.println("패스워드 변경하소");
				break;
			case "12":
				System.out.println("패스워드 오류");
				break;
			case "34":
				System.out.println("패스워드 오류2");
				break;
			default:
				System.out.println("전체 오류");
				// break;
		}

		// 3항연산 연습
		String result = (passwd.equals("12345")) ? "로그인 성공" : "로그인 실패";
		System.out.println(result);
	}

}
