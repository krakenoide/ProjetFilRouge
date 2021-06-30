package com.springmvc.modeles;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genres")
public class Genre {
    @Id    
    @GeneratedValue(strategy=GenerationType.IDENTITY) //permet d'autoincrémenter les id en mettant des null    
    @Column(name="id") //car mon nom de colomne est le meme que mon attribut    
    int id;
    
    @Column(name="Nom")
    String nomGenre;
    
    //@OneToMany(mappedBy="id_genre",fetch=FetchType.LAZY,cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    //private List<Morceau> morceaux;
    
    Genre(){
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomGenre() {
        return nomGenre;
    }
    public void setNomGenre(String nomGenre) {
        this.nomGenre = nomGenre;
    }
}
