package com.example.LOGdatabase.domain;
import java.sql.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
public interface LogFileRepository extends CrudRepository<LogFile, String> {
	/*List<LogFileRepository> findByid_LOG( String id_LOG);
	  List<LogFileRepository> findByname(String name);
	  List<LogFileRepository> findBydate(Date date);*/
	 
}
