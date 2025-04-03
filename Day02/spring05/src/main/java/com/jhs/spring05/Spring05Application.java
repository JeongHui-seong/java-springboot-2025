package com.jhs.spring05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring05Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring05Application.class, args);

		// 상속
		Dog puppy = new Dog();
		puppy.setName("뽀삐");
		puppy.cry();
		// puppy.age = 8;
		puppy.setAge(450);
		System.out.println("뽀삐의 나이는 " + puppy.getAge());
		
		Cat kitty = new Cat();
		kitty.setName("키티");
		kitty.cry();
		kitty.setAge(12);
		System.out.println("키티의 나이는 " + kitty.getAge());
		// kitty.age = 3;

		Dog choonsam = new Dog();
		choonsam.setName("춘삼");
		choonsam.cry();
		System.out.println(choonsam.getClass().getSimpleName()); // Object 클래스 메서드를 사용가능
	}

}
