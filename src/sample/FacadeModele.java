package sample;

import javafx.scene.input.KeyCode;

public class FacadeModele {
    ModeleConcret    modele = new ModeleConcret();

    public void move (KeyCode code, String direction) {
        modele.move(code, direction);
    }

    /*public void reset() {
        modele.reset();
    }

    public int nbCoup() {
        return modele.nbCoup;
    }*/

    public int[][] getEtat() {
        return modele.getEtat();
    }

}
