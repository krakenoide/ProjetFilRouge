package com.springmvc.daoimplementation;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.DataSummaryDao;
import com.springmvc.modeles.Album;
import com.springmvc.modeles.Artiste;
import com.springmvc.modeles.Genre;
import com.springmvc.modeles.Morceau;

@Repository
public class DataSummaryDaoImplementation implements DataSummaryDao{
	@Autowired
	private SessionFactory sessionfactory;
	
	private List<Artiste> listeArtistes;
    private List<Genre> listeGenres;
    private List<Morceau> listeMorceaux;
    private List<Album> listeAlbums;
    
    public void conversionimage() throws IOException{
    	for (int i=0;i<this.getListeArtistes().size();i++) {
			String chemin1="C:/Users/brice/eclipse-workspace/projetfilrougegit/src/main/webapp/ressourcesweb/images/mes_artistes/"+
							"artiste"+(i+1)+".png";
			File file = new File(chemin1);
			if (this.getListeArtistes().get(i).getPhotoArtiste()!=null) {
				ImageIO.write(ImageIO.read(new ByteArrayInputStream(this.getListeArtistes().get(i).getPhotoArtiste())),"PNG",file);
			}
		}
    	for (int i=0;i<this.getListeAlbums().size();i++) {
			String chemin2="C:/Users/brice/eclipse-workspace/projetfilrougegit/src/main/webapp/ressourcesweb/images/mes_albums/"+
							"album"+(i+1)+".png";
			File file = new File(chemin2);
			if (this.getListeAlbums().get(i).getCouverture()!=null) {
				ImageIO.write(ImageIO.read(new ByteArrayInputStream(this.getListeAlbums().get(i).getCouverture())),"PNG",file);
			}
		}
    }
    
    public void delete() throws IOException{
    	for (int i=0;i<this.getListeArtistes().size();i++) {
			String chemin1="C:/Users/brice/eclipse-workspace/projetfilrougegit/src/main/webapp/ressourcesweb/images/mes_artistes/"+
							"artiste"+(i+1)+".png";
			File file=new File(chemin1);
			file.delete();
		}
    	for (int i=0;i<this.getListeAlbums().size();i++) {
			String chemin2="C:/Users/brice/eclipse-workspace/projetfilrougegit/src/main/webapp/ressourcesweb/images/mes_albums/"+
							"album"+(i+1)+".png";
			File file = new File(chemin2);
			file.delete();
		}
    }

	@Transactional
	public void recup() throws IOException {
		Session session =sessionfactory.getCurrentSession();
		this.setListeArtistes(session.createQuery("FROM Artiste").getResultList());
		this.setListeGenres(session.createQuery("FROM Genre").getResultList()); 
		this.setListeMorceaux(session.createQuery("FROM Morceau").getResultList()); 
		this.setListeAlbums(session.createQuery("FROM Album").getResultList()); 
		conversionimage();	
	}
	
	@Transactional
    public void recupSearchMorceaux(String search) throws IOException {
        Session session =sessionfactory.getCurrentSession();
        this.setListeArtistes(session.createQuery("FROM Artiste").getResultList());
        this.setListeGenres(session.createQuery("FROM Genre").getResultList()); 
        this.setListeMorceaux(session.createQuery("FROM Morceau WHERE Nom like '%"+search+"%'").getResultList()); 
        this.setListeAlbums(session.createQuery("FROM Album").getResultList()); 
        conversionimage();      
    }
    
    @Transactional
    public void recupSearchArtistes(String search) throws IOException {
        Session session =sessionfactory.getCurrentSession();
        this.setListeArtistes(session.createQuery("FROM Artiste WHERE Nom like '%"+search+"%'").getResultList());
        this.setListeGenres(session.createQuery("FROM Genre").getResultList()); 
        this.setListeMorceaux(session.createQuery("FROM Morceau").getResultList()); 
        this.setListeAlbums(session.createQuery("FROM Album").getResultList()); 
        conversionimage();      
    }
    
    @Transactional
    public void recupSearchAlbums(String search) throws IOException {
        Session session =sessionfactory.getCurrentSession();
        this.setListeArtistes(session.createQuery("FROM Artiste").getResultList());
        this.setListeGenres(session.createQuery("FROM Genre").getResultList()); 
        this.setListeMorceaux(session.createQuery("FROM Morceau").getResultList()); 
        this.setListeAlbums(session.createQuery("FROM Album WHERE nom_album like '%"+search+"%'").getResultList()); 
        conversionimage();      
    }
	
	public List<Artiste> getListeArtistes() {
		return listeArtistes;
	}
	public void setListeArtistes(List<Artiste> listeArtistes) {
		this.listeArtistes = listeArtistes;
	}
	public List<Genre> getListeGenres() {
		return listeGenres;
	}
	public void setListeGenres(List<Genre> listeGenres) {
		this.listeGenres = listeGenres;
	}
	public List<Morceau> getListeMorceaux() {
		return listeMorceaux;
	}
	public void setListeMorceaux(List<Morceau> listeMorceaux) {
		this.listeMorceaux = listeMorceaux;
	}
	public List<Album> getListeAlbums() {
		return listeAlbums;
	}
	public void setListeAlbums(List<Album> listeAlbums) {
		this.listeAlbums = listeAlbums;
	}

}
