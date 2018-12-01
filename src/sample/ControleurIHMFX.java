package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

public class ControleurIHMFX {
    Controleur controleur;
    VueIHMFX vue;
    Button reset;

    ControleurIHMFX(Controleur controleur, VueIHMFX vue) {
        this.controleur = controleur;
        this.vue = vue;


    }

    class ActionReset implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            controleur.reset();
        }

    }

    class MyAction implements EventHandler<ActionEvent> {
        int indice;

        MyAction(int indice) {
            this.indice = indice;
        }

        @Override
        public void handle(ActionEvent event) {
           // controleur.move(KeyCode code);
        }
    }
}