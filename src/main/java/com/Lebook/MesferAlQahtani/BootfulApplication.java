package com.Lebook.MesferAlQahtani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BootfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootfulApplication.class, args);

//		String encoded=new BCryptPasswordEncoder().encode("mnq1234");
//		System.out.println(encoded);
	}
}
