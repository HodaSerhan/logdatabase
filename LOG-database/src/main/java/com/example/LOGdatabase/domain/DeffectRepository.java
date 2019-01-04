package com.example.LOGdatabase.domain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
public interface DeffectRepository extends CrudRepository<Deffect, String> {
	/* List<Deffect> findByID_DEF(String ID_DEF);
	 List<Deffect> findBySeverity(String Severity);
	  List<Deffect> findByErrorcode(String errorcode);
	  List<Deffect> findByID_sol( String ID_sol);
*/
	}



