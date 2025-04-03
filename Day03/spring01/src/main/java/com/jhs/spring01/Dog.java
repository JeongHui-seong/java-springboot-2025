package com.jhs.spring01;

// interface는 implements 키워드를 사용해야함
public class Dog implements Animal {
    private String name;
    private int age;
    
    // 생성자
    Dog(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override // 오버라이딩
    public void cry() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'cry'");
        System.out.println(this.age + "살 " + this.name + "이(가) 멍멍");
    }

}
