package com.jhs.spring01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring01Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring01Application.class, args);

		// StringBuilder
		StringBuilder sb = new StringBuilder();
		sb.append("Hello ");
		sb.append("Java");

		System.out.println(sb.toString());
		System.out.println(sb); // StringBuilder 객체만으로도 출력, 
		
		StringBuilder sb2 = new StringBuilder("Hi ");
		sb2.append("JHS");
		// 리스트처럼 중간에 내용 삽입 가능
		sb2.insert(3, "Nice to meet you, ");
		System.out.println(sb2.toString());
		// 문자열 길이 확인
		System.out.println(sb2.length());
		// 문자열 삭제
		sb2.delete(19,24); // 지울 문자열의 시작 인덱스부터 마지막 인덱스까지
		System.out.println(sb2.toString());
		// 인덱스위치 문자 하나 삭제
		sb2.deleteCharAt(3);
		System.out.println(sb2.toString());

		// 문자열 거꾸로 변환
		System.out.println(sb2.reverse());
		sb2.reverse();
		
		//문자열 대체
		sb2.replace(0,1,"h");
		System.out.println(sb2.toString());
		
		// 문자열 자르기, 자른 값을 다른 변수에 할당해야 사용 가능
		System.out.println(sb2.substring(9));

		// 문자열
		StringBuilder sb3 = new StringBuilder("   Hello   ");
		System.out.println(sb3.toString().trim());

		// StringBuffer
		StringBuffer sf = new StringBuffer();
		sf.append("Hi Java");
		sf.insert(3, "C# and ");
		System.out.println(sf);
	}

}
