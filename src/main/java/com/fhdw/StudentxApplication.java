package com.fhdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fhdw.gui.ServerGui;

@SpringBootApplication
@ComponentScan
@Configuration
public class StudentxApplication {

	public static void main(String[] args) {
		ServerGui instanz = new ServerGui();
		instanz.setVisible(true);
	}
	
	public static void start(){
		SpringApplication.run(StudentxApplication.class);
	}
	
	public static void stop() {
	    System.exit(0);
	}
	
}