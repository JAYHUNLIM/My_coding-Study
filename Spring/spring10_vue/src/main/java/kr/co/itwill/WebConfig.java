package kr.co.itwill;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//클라이언트에서 접속할수 있도록 보안설정
//8080포트에서 온 HOST는 허용해 준다
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**").allowedOrigins("http://localhost:8080");
		//8080에서 요청한 것에 대해서 답을 주겠다
	}
	
	public WebConfig() {
	
	}
	
}
