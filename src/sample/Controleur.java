package sample;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class Controleur implements Sujet {
    private static Controleur singleton;


    public static Controleur getControleur() {
        if (singleton == null)
            singleton = new Controleur(new FacadeModele());
        return singleton;
    }

    FacadeModele facadeModele;
    ArrayList<Observateur> observateurs = new ArrayList<Observateur>();

    private Controleur(FacadeModele facadeModele) {
        this.facadeModele = facadeModele;
    }

    public void abonne(Observateur observateur) {
        observateurs.add(observateur);
    }

    @Override
    public void notifie() {
        for (Observateur observateur:observateurs)
            observateur.actualise();
    }

    public void move(KeyCode code, String direction) {
        facadeModele.move(code,direction);
        notifie();
    }

    public void reset() {
       /*facadeModele.reset();
        notifie();*/
    }

    public CommandeInt commandeNbCoup() {
        return new CommandeInt() {
            @Override
            public int exec() {
                /* return facadeModele.nbCoup();*/
                return 0;
            }

        };
    }

    public CommandeTabInt commandeGetEtat() {
       /* return new CommandeTabInt() {
            @Override
            public int[] exec() {
                return facadeModele.getEtat();
            }
        };*/
       return null;
    }
}
