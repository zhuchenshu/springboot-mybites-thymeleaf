package com.mybites.demo;

import com.mybites.demo.config.StorageProperties;
import com.mybites.demo.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.mybites.demo.dao")
@EnableConfigurationProperties(StorageProperties.class)
public class DemoApplication  extends WebMvcConfigurerAdapter implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starter");
	}
}
