package com.example.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShopApplication.class, args);

//		new Friend("kim");
//		var test = new Friend("park");
//		System.out.println(test.name);
		var a = new NameAge();

		// Reference Type : Integer (객체) - 변수에 (객체의) 주소가 담겨
		// Primitive Type : int (값)		  - 변수에 		  값이 담겨
		a.setName("홍길동");

		a.setAge(60);
		a.나이설정(101);

		a.한살더하기();
		System.out.println(a.getAge());

	}
}

//class Friend {
//	String name = "kim";
//	int age = 20;
//	Friend(String 구멍){
//		this.name = 구멍;
//	}
//	Friend(String name, int age){
//		this.age = 20;
//	}
//}
