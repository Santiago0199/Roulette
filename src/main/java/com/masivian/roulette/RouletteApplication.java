package com.masivian.roulette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.masivian.roulette.conf.ValidationConfig;

@SpringBootApplication
@EnableConfigurationProperties({ValidationConfig.class})
public class RouletteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouletteApplication.class, args);
	}

}
