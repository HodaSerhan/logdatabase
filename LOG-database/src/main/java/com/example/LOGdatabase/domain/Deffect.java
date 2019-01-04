package com.example.LOGdatabase.domain;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Deffect {
	 @Id
	 private String id_def;
	 private String severity;
	 private String errorcode;
	 private String id_sol;
	 
	 
	 
    

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "solution_id")
     private Solutions solution_id;
     
	 @OneToMany(cascade = CascadeType.ALL, mappedBy="deffect_id")

	 private List<Deffect_instance> DeffectsIns;
     //Getter and setter
     public List<Deffect_instance> getDeffect_Instance() {
       return DeffectsIns;
     }
     public void setDeffect_Instance(List<Deffect_instance> defects) {
       this.DeffectsIns = defects;
     }
	 
	public String getID_DEF() {
		return id_def;
	}
	public void setID_DEF(String iD_DEF) {
		id_def = iD_DEF;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		severity = severity;
	}
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getID_sol() {
		return id_sol;
	}
	public void setID_sol(String iD_sol) {
		id_sol = iD_sol;
	}
	public Deffect(String iD_DEF, String severity, String errorcode, String iD_sol) {
		super();
		id_def = iD_DEF;
		severity = severity;
		this.errorcode = errorcode;
		id_sol = iD_sol;
	}
	public Deffect() {
		super();
		// TODO Auto-generated constructor stub
	}

}
