package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;


public class IHMFX extends Application implements Observateur {
    VueNbCoupIHMFX vueNbCoup;
    VueIHMFX vue;
    Controleur controleur;
    String direction = "bottom";
    int x=ModeleConcret.x;
    int y =ModeleConcret.y;
    int[][] map = ModeleConcret.getEtat();
    // améliorer les entrées clavier
        public void play (Scene scene, GraphicsContext g2d){

            scene.setOnKeyPressed(new EventHandler<Event>() {
                public void handle(Event event) {
                    //获取键码
                    KeyEvent ke = (KeyEvent) event;
                    //强转
                    KeyCode code = ke.getCode();
                    controleur.move(code, direction);
                    int[][] map = ModeleConcret.getEtat();
                    vue.drawMap(g2d, map, ModeleConcret.x, ModeleConcret.y, direction);
                }
            });
        }
        ;

    public void actualise(){

    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            AnchorPane root = new AnchorPane();
            Scene scene = new Scene(root,1000,1000);
            //调用方法,完成游戏相关操作
            game(root,scene);

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void game(AnchorPane root, Scene scene) {
        //创建画布
        Canvas canvas = new Canvas(1000,1000);
        //通过画布获取画笔
        GraphicsContext g2d = canvas.getGraphicsContext2D();
        //画地图  调用方法画地图
        vue.drawMap(g2d,map,x,y,direction);
        root.getChildren().add(canvas);
        //玩游戏
        play(scene,g2d);
    }

    public void lance() {
        launch(new String[]{});
    }
}

