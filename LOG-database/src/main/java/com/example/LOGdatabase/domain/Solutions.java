package com.example.LOGdatabase.domain;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Solutions {
	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	 private String  ID_Sol;
	 private String Name_Sol;
	 private String Des;
	 
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy="solution_id")

	 private List<Deffect> Deffects;
     //Getter and setter
     public List<Deffect> getDeffects() {
       return Deffects;
     }
     public void setDeffects(List<Deffect> defects) {
       this.Deffects = defects;
     }
	 
	 
	 
	public String getID_Sol() {
		return ID_Sol;
	}
	public void setID_Sol(String iD_Sol) {
		ID_Sol = iD_Sol;
	}
	public String getName_Sol() {
		return Name_Sol;
	}
	public void setName_Sol(String name_Sol) {
		Name_Sol = name_Sol;
	}
	public String getDes() {
		return Des;
	}
	public void setDes(String des) {
		Des = des;
	}
	public Solutions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Solutions(String iD_Sol, String name_Sol, String des) {
		super();
		ID_Sol = iD_Sol;
		Name_Sol = name_Sol;
		Des = des;
	}

}