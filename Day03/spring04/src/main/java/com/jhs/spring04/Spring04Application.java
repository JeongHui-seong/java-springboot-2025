package com.jhs.spring04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring04Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring04Application.class, args);

		// 문자열, 시간타입 핸들링
		String greeting = "Hello"; // 일반적으로 사용
		System.out.println(greeting);

		String hi = new String("Hello"); // 기본
		System.out.println(hi);

		System.out.println(greeting == hi); // 둘이 같은 주소를 쓰는 변수인지 질문
		System.out.println(greeting.equals(hi));
		
		String string3 = hi; // 주소 할당

		System.out.println(hi == string3);
		System.out.println(hi.equals(string3));

		// 문자열 메서드 연습
		String carstr = "avante, ionic, x3";
		String cars[] = carstr.split(","); // String 타입은 한 글자라도 '' 못씀 char 타입에서만 가능
		// String[] cars = carstr.split(","); // 위랑 같음
		for (String car : cars) {
			System.out.println(car.trim());
		}
		
		for (String car : cars) {
			System.out.println(car.toUpperCase());
		}

		String carresult1 = carstr.replace(", ", "/");
		System.out.println(carresult1);

		String carresult2 = carstr.replace(',', '/'); // Java에서 ''는 Char(글자 한자)
		System.out.println(carresult2);

		char[] charlst = greeting.toCharArray();
		for (char char1 : charlst) {
			System.out.println(char1);
		}

		System.out.println(carresult1.indexOf("io")); // avante/ionic/x3 io의 위치
		System.out.println(carresult1.lastIndexOf("n")); // 마지막 n의 위치
		System.out.println(carresult1.length()); // 글자 길이
	}


}
