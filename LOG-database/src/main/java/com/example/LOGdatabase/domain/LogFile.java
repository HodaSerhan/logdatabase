package com.example.LOGdatabase.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class LogFile {
	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private String id_LOG;
   	  private String name;
      private	Date date;
      
      
  @OneToMany(cascade = CascadeType.ALL, mappedBy="logFile_id")
      private List<Deffect_instance> DeffectsIns;
      //Getter and setter
      public List<Deffect_instance> getDeffect_Instance() {
        return DeffectsIns;
      }

      public void setDeffect_Instance(List<Deffect_instance> defects) {
        this.DeffectsIns = defects;
      }
      
      
      
	public String getId_LOG() {
		return id_LOG;
	}
	public void setId_LOG(String id_LOG) {
		this.id_LOG = id_LOG;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public LogFile(String id_LOG, String name, Date date) {
		super();
		this.id_LOG = id_LOG;
		this.name = name;
		this.date = date;
	}
	public LogFile() {
		super();
		// TODO Auto-generated constructor stub
	}


      

}
