package com.jhs.spring02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring02Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring02Application.class, args);

		// 배열
		int[] score = {90, 98, 100, 76, 83};
		System.out.println(score.length);
		
		score[4] = 85; // 네번째 인덱스 값을 83에서 85로 변경
		System.out.println(score); // 배열 변수를 출력한다고 값을 표시하지 않음

		for(int i = 0; i < score.length; i++){
			System.out.println(score[i]);
		}

		String[] carcompany = {"Hyundai", "Kia", "Toyota", "Benz", "BMW", "Tesla"};
		
		for (String car: carcompany){
			System.out.println(car);
		}

		// Java 컬렉션으로 변경
		List <String> car_list = Arrays.asList(carcompany);
		System.out.println(car_list); // 파이썬과 동일
		System.out.println(car_list.get(1));

		Arrays.sort(score);
		for(int item : score){
			System.out.println(item);
		}

		Arrays.sort(carcompany, Collections.reverseOrder());
		for(String item : carcompany){
			System.out.println(item);
		}
	}

}
