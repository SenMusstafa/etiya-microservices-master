package com.etiya.exampleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleserviceApplication {

	public static void main(String[] args) {
		// JavaDoc => Summary
		SpringApplication.run(ExampleserviceApplication.class, args);
	}
	// SOLID ==> OOP Principles
	// S => Single Responsibility Principle
	// O => Open/Closed Principle
	// L => Liskov Subs.
	// I => Interface Segregation
	// D => Dependency Inversion

	// Test Odaklı Geliştirme - Yazılımın doğru çalıştığını doğrulamak.
	// Event/Behavior Odaklı Geliştirme - Business
	// Domain Odaklı Geliştirme

	// TDD, DDD, EDD-BDD
}
