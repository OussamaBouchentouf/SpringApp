package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.MaterielDAO;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.ArrayList;

public class GestionMaterielServiceImpl implements GestionMaterielService {
    // bd goes here
    MaterielDAO materielDAO;
    private int nbrLivres = 0;
    private int nbrChaises = 0;

    public GestionMaterielServiceImpl(MaterielDAO materielDAO) {
        this.materielDAO = materielDAO;
    }

    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void listerMateriel() {
        System.out.println("Liste de materiel :\n" + this.nbrLivres + " Livres \n" + this.nbrChaises + " chaises");
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
        if (materiel instanceof Livre) {
            this.nbrLivres++;
        } else {
            this.nbrChaises++;
        }
        materielDAO.addMateriels(materiel);
        System.out.println("L'ajout du materiel " + materiel.getName() + " effectue avec succes !");
    }

    @Override
    public void supprimerUnMateriel(int id) {
        for (int i = 0; i < materielDAO.getMateriels().size(); i++) {
            if (materielDAO.getMateriels().get(i).getId() == id) {
                if (materielDAO.getMateriels().get(i) instanceof Livre) {
                    this.nbrLivres--;
                } else {
                    this.nbrChaises--;
                }
                materielDAO.deleteMateriels(materielDAO.getMateriels().get(i));
                System.out.println("Materiel bien supprimer");
                break;
            }
            if (i == materielDAO.getMateriels().size() - 1) {
                System.out.println("Pas de materiel avec cet id");
            }
        }
    }

    @Override
    public void modifierUnMateriel(int id) {
        for (int i = 0; i < materielDAO.getMateriels().size(); i++) {
            if (materielDAO.getMateriels().get(i).getId() == id) {
                materielDAO.getMateriels().get(i).setName("wijdane");
                System.out.println("id : " + materielDAO.getMateriels().get(i).getId() + "\nNom :" + materielDAO.getMateriels().get(i).getName());
            }
        }
    }

    @Override
    public void rechercherUnMateriel(int id) {
        for (int i = 0; i < materielDAO.getMateriels().size(); i++) {
            if (materielDAO.getMateriels().get(i).getId() == id) {
                System.out.println("----------------------------------------------------------\nid : " + materielDAO.getMateriels().get(i).getId() + "\nNom :"
                        + materielDAO.getMateriels().get(i).getName() +
                        "\n----------------------------------------------------------\n");
                break;
            }
            if (i == materielDAO.getMateriels().size() - 1) {
                System.out.println("Pas de materiel avec cet id");
            }
        }
    }
}
