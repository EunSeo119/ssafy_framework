package com.ssafy.config;

import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.interceptor.ConfirmInterceptor;

// 이 클래스는 전역이다!라고 생각하면 편하다
@Configuration
@MapperScan(basePackages = { "com.ssafy.**.mapper" })
public class WebMvcConfiguration implements WebMvcConfigurer {

	private final List<String> patterns = Arrays.asList("/article/*", "/admin", "/user/list");
	
	private ConfirmInterceptor confirmInterceptor;

	public WebMvcConfiguration(ConfirmInterceptor confirmInterceptor) {
		this.confirmInterceptor = confirmInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(confirmInterceptor).addPathPatterns(patterns);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
//			.allowedOrigins("http://www.ssafy.com", "http://localhost", "http://localhost:8080")
			.allowedMethods("GET", "POST", "UPDATE", "DELETE")
//			.allowedMethods(RequestMethod.GET.name(), RequestMethod.POST.name(), ..)
//			.allowedMethods("*")
			.maxAge(1800);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// 컨트롤러 따로 안만들어도되고 이런 것들 여러개 등록하면 단순 페이지이동같은것 처리 가능! or redirect 같은 것들!(MemberController에서 getMapping받는 join()같은거)
		registry.addViewController("/").setViewName("index2");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	
	
}
