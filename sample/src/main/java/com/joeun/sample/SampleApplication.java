package com.joeun.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링 부투 애플리케이션의 시작점이 되는 클래스
@SpringBootApplication		// 스프링 부트의 주요 설정 클래스 지정 - 설정 초기화
public class SampleApplication {

	// main 메소드 : 프로그램 시작
	// 내장된 웹 서버(Tomcat)를 웹 애플리케이션을 초기화하고 구동(실행)
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
