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
		//ServerGui instanz = new ServerGui();
		//instanz.setVisible(true);
		studentxApplicationStart();
	}
	
	public static void studentxApplicationStart(){
		SpringApplication.run(StudentxApplication.class);
	}
	
	public static void studentxApplicationStop() {
	    System.exit(0);
	}
	
}