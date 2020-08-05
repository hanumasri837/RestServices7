package com.projectcodeforce.one;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@EnableJpaRepositories(basePackages = "com.projectcodeforce.one.config.User")

@SpringBootApplication
public class Projectcodeforce1Application {

	public static void main(String[] args) {
		SpringApplication.run(Projectcodeforce1Application.class, args);
	}
	
}
