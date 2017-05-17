package com.fhdw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fhdw.gui.ServerGui;

@SpringBootApplication
@ComponentScan
@Configuration
public class StudentxApplication {
	 @Autowired
	 private static ApplicationContext appContext;

	public static void main(String[] args) {
		ServerGui instanz = new ServerGui();
		instanz.setVisible(true);
		//start();
	}
	
	public static void start(){
		appContext=SpringApplication.run(StudentxApplication.class);
	}
	@Autowired
	public static void stop() {
		ExitCodeGenerator exitCodeGenerator = new ExitCodeGenerator(){ 
		@Override
	        public int getExitCode() {
	            return 5;
	        }
	    };
	    SpringApplication.exit(appContext, exitCodeGenerator);
	}
	
}