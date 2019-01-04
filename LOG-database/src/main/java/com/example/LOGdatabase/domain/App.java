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
public class App {
	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private long id_app;
	 private String name;
	 private String type;
	 
	 public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy="app_id")
     private List<Deffect_instance> DeffectsIns;
     //Getter and setter
     public List<Deffect_instance> getDeffect_Instance() {
       return DeffectsIns;
     }

     public void setDeffect_Instance(List<Deffect_instance> defects) {
       this.DeffectsIns = defects;
     }	 
	public long getId_App() {
		return id_app;
	}
	public void setId_App(long id_App) {
		this.id_app = id_App;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
	}
	public App(long id_App, String name,String type) {
		super();
		this.id_app = id_App;
		this.type=type;
		name = name;
	}
	public App() {
		super();
		// TODO Auto-generated constructor stub
	};
	 
}
