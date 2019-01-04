package com.example.LOGdatabase;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.example.LOGdatabase.domain.App;
import com.example.LOGdatabase.domain.AppRepository;
import com.example.LOGdatabase.domain.Deffect;
import com.example.LOGdatabase.domain.DeffectRepository;
import com.example.LOGdatabase.domain.Deffect_instanceRepository;
import com.example.LOGdatabase.domain.LogFileRepository;

@SpringBootApplication
public class LogDatabaseApplication {

	private static final Logger logger = LoggerFactory.getLogger(LogDatabaseApplication.class);

	@Autowired
	private DeffectRepository defRep;
	@Autowired
	private AppRepository appRep;
	@Autowired
	private  Deffect_instanceRepository diRep;
	@Autowired
	private LogFileRepository logappRep;
	public static void main(String[] args) {
		SpringApplication.run(LogDatabaseApplication.class, args);

		logger.info("Hello Spring Boot");
	}

	@Bean
	CommandLineRunner runner(){
		
		Start.readLogs();
		
		return args -> {
			for (Map.Entry<String, Integer> entry : Start.appsErrCounters.entrySet()) 
				defRep.save(new Deffect(entry.getKey(), "warrning", "000036",entry.getValue().toString()));
		    	appRep.save(new App( 123456, "000036","core"));
			
		};
	} 


}
