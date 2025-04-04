package com.jhs.spring02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring02Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring02Application.class, args);

		// 제네릭 문자열사용
		Storage<String> storage1 = new Storage<String>();
		storage1.setItem("Iconic");
		System.out.println(storage1.getItem());

		// 제네릭 정수사용
		Storage<Integer> storage2 = new Storage<>();
		storage2.setItem(2018);
		System.out.println(storage2.getItem());

		// 제네릭 실수사용
		Storage<Float> storage3 = new Storage<>();
		storage3.setItem(3.141592f);
		System.out.println(storage3.getItem());

		// 리턴타입 및 인자가 모두 제네릭일 때 처리
		Spring02Application app = new Spring02Application();
		System.out.println(app.convert(storage1));
		System.out.println(app.convert(storage2));
	}

	// storage에 들어온 아이템을 문자로 분리해서 리스트에 담는 기능
	public <P> List<Character> convert(Storage<P> storage) {
		ArrayList<Character> list = new ArrayList<>();

		String s = String.valueOf(storage.getItem());
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}

		return list;
	}

	// 제네릭타입으로 어떤 타입이 들어올지 모를 때 쓰는 와일드카드
	public void print(Storage<? extends Storage> st) {
		// 내용 생략.
	}

}
