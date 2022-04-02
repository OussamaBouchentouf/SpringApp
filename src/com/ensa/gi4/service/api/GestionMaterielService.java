package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Materiel;

public interface GestionMaterielService {
    void init();
    void listerMateriel();
    void ajouterNouveauMateriel(Materiel materiel);
    void supprimerUnMateriel(int id);
    void modifierUnMateriel(int id);
    void rechercherUnMateriel(int id);
}
