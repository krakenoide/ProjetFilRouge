package com.springmvc.modeles;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="sons")
public class Son {
    @Id    
    @GeneratedValue(strategy=GenerationType.IDENTITY) //permet d'autoincr�menter les id en mettant des null    
    @Column(name="id") //car mon nom de colomne est le meme que mon attribut    
    int id;
    
    @Lob
	@Column(name = "Son", columnDefinition="BLOB")
	private byte [] son;
        
    Son(){
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
	public byte[] getSon() {
		return son;
	}
	public void setSon(byte[] son) {
		this.son = son;
	}
    
    
}
