package cn.com.taiji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // 只返回string字符串
public class Jpa3Application {

	public static void main(String[] args) {
		SpringApplication.run(Jpa3Application.class, args);
	}
}
