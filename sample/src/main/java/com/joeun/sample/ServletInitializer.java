package com.joeun.sample;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// 서블릿을 초기화하는 클래스
// - WAR 파일로 프로젝트를 패키징
// - 서블릿 컨테이너의 배포할 설정들을 초기화
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SampleApplication.class); 	// 스프링 부트 구동 클래스를 지정
	}

}
