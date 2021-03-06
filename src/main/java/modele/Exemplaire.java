package modele;

import java.io.Serializable;
import java.time.LocalDate;


public class Exemplaire implements Serializable {
    
    // Attributs
    private static final long serialVersionUID = 1L;  // nécessaire pour la sérialisation
    private LocalDate dateRecep;
    private Boolean estEmpruntable;
    private final Integer numExemplaire;
    private Ouvrage ouvrage;
    private Emprunt emprunt;
    
    // Constructeur
    public Exemplaire(LocalDate dateRecep, Boolean estEmpruntable, Ouvrage ouvrage) {
        this.dateRecep = dateRecep ;
        this.estEmpruntable = estEmpruntable ;
        this.lierOuvrage(ouvrage) ;
        this.numExemplaire = this.ouvrage.getNumDernierExemplaire() ;
    }

    private void lierOuvrage (Ouvrage ouvrage) {
        this.ouvrage = ouvrage ;
    }

    public void setEmprunt (Emprunt em) {
        emprunt = em;
    }

    public void retirerEmprunt() {
        emprunt = null ;
    }

    // Getters
    public LocalDate getDateRecep() {
        return dateRecep;
    }
    
    public Integer getNumExemplaire() {
        return numExemplaire;
    }
    
    public Lecteur getLecteur() {
        return getEmprunt().getLecteur() ;
    }
    
    public Ouvrage getOuvrage() {
        return ouvrage ;
    }

    public Emprunt getEmprunt() {
        return emprunt ;
    }

    // Méthodes d'état d'un exemplaire
    public boolean estDisponible() {
        return (estEmpruntable == true && emprunt == null) ;
    }

    public boolean estEmprunte() {
        return (estEmpruntable == true && emprunt != null) ;
    }
}
