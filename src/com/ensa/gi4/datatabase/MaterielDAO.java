package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Materiel;

import java.util.ArrayList;
import java.util.List;

public class MaterielDAO {
    private List<Materiel> materiels = new ArrayList<>();
    public MaterielDAO() { }

    public List<Materiel> getMateriels() {
        return materiels;
    }

    public void addMateriels(Materiel materiels) {
        this.materiels.add(materiels);
    }
    public void deleteMateriels(Materiel materiels) {
        this.materiels.remove(materiels);
    }

}
