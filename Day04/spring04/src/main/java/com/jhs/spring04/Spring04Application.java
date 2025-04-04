package com.jhs.spring04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring04Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring04Application.class, args);

		// 람다식
		// 1. 일반방식
		Spring04Application app = new Spring04Application();
		System.out.println(app.helloJava());

		// 2. 람다방식
		myFuncInterface fi = () -> { System.out.println("Hello, Java 람다 호출"); };
		fi.printHello();

		myCalc calculator = (x, y) -> { return x + y; };
		int result = calculator.plus(100, 55);
		System.out.println(result);

		// Stream API
		// 1. 기존 방식
		List<String> avengers = Arrays.asList("Ironman", "Captain America", "SpiderMan", "Hulk", "AntMan");

		// 정렬
		Collections.sort(avengers);
		System.out.println(avengers);
		for (String hero : avengers) {
			System.out.println(hero);
		}
		// 단점은 출력시 반복문 사용, 정렬 후 원본 훼손
		System.out.println("===============================");
		// 2. 스트림 API 사용방식
		avengers = Arrays.asList("Ironman", "Captain America", "SpiderMan", "Hulk", "AntMan");

		Stream<String> avengersStream = avengers.stream();
		avengersStream.sorted().forEach(System.out::println);
		System.out.println(avengers);

		// 스트림API 실습
		List<String> originList = Arrays.asList("a1", "c2", "b3", "c1", "a2", "b1");

		// c로 시작하는 요소를 대문자로 변경
		List<String> copyList = new ArrayList<>(originList);
		System.out.println(originList);
		for(String str1 : copyList) {
			if(str1.contains("c")) {
				str1 = str1.replace(copyList.get(copyList.indexOf(str1)), str1.toUpperCase());
			}
		}
		System.out.println(copyList);

		// 1. 각 요소에서 c로 시작하는 것만 추출
		List<String> lastList = new ArrayList<>();
		for (String elmt : copyList) {
			if (elmt.startsWith("c")) {
				lastList.add(elmt);
			}
		}

		// 2. 대문자변경
		for(int i = 0; i < lastList.size(); i++) {
			lastList.set(i, lastList.get(i).toUpperCase());
		}

		// 3. 정렬
		Collections.sort(lastList);
		System.out.println(lastList.size());

		// 스트림API를 쓰면
		System.out.println(originList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().toList());
		
	}

	// 일반 메서드 호출
	public String helloJava() {
		return "Hello, Java 일반 호출";
	}

	@FunctionalInterface // 함수형 인터페이스로 지칭, 함수형 인터페이스 만들 때 지켜야할 약속들 체크
	public interface myFuncInterface {
		void printHello();
	}

	public interface myCalc {
		int plus(int x, int y);
	}
}
