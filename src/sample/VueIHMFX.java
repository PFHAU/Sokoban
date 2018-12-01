package sample;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

public class VueIHMFX {
    public static void drawMap(GraphicsContext g2d, int[][] map, int x, int y, String direction) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                /**
                 * Image img  图片
                 * double x	  开始放的X坐标
                 * double y  开始放的Y坐标
                 * double w  画多宽/压缩画
                 * double h  画多高/压缩画
                 */
                switch (map[i][j]) {
                    case 0:
                        Image land =new Image(VueIHMFX.class.getResource("/Sokoban_pack/PNG/Ground_Grass.png").toString());
                        g2d.drawImage(land,j*50,i*50,50,50);
                        break;
                    case 1:
                        Image way =new Image(VueIHMFX.class.getResource("/Sokoban_pack/PNG/GroundGravel_Grass.png").toString());
                        g2d.drawImage(way,j*50,i*50,50,50);
                        break;
                    case 2:
                        Image wall =new Image(VueIHMFX.class.getResource("/Sokoban_pack/PNG/Wall_Beige.png").toString());
                        g2d.drawImage(wall,j*50,i*50,50,50);
                        break;
                    case 3:
                        Image box_way =new Image(VueIHMFX.class.getResource("/Sokoban_pack/PNG/Crate_Beige.png").toString());
                        g2d.drawImage(box_way,j*50,i*50,50,50);
                        Image box =new Image(VueIHMFX.class.getResource("/Sokoban_pack/PNG/Crate_Beige.png").toString());
                        g2d.drawImage(box,j*50,i*50,50,50);
                        break;
                    case 4:
                        Image way2 =new Image(VueIHMFX.class.getResource("/Sokoban_pack/PNG/GroundGravel_Sand.png").toString());
                        g2d.drawImage(way2,j*50,i*50,50,50);
                        Image box_end =new Image(VueIHMFX.class.getResource("/Sokoban_pack/PNG/EndPoint_Red.png").toString());
                        g2d.drawImage(box_end,j*50+10,i*50+10,30,30);
                        break;
                    case 5:
                        //记录玩家的初始位置
                        x= i;
                        y = j;
                        Image way3 =new Image(VueIHMFX.class.getResource("/Sokoban_pack/PNG/EndPoint_Yellow.png").toString());
                        g2d.drawImage(way3,j*50,i*50,50,50);
                        Image player = new Image(VueIHMFX.class.getResource("/Sokoban_pack/PNG/Character1"+direction+".png").toString());
                        g2d.drawImage(player,j*50,i*50,50,50);
                        break;
                    default:
                        break;
                }
            }
        }
    }
/*
    CommandeTabInt commandeGetEtat;
    Button[] myButton;
    GridPane gridPane = new GridPane();

    Image[] chameau = new Image[]{ new Image(new FileInputStream(
            "chameau0.gif"),80,80,false,false),
            new Image(new FileInputStream(
                    "chameau1.png"),80,80,false,false),
            new Image(new FileInputStream(
                    "chameau2.jpg"),80,80,false,false)};


    public VueIHMFX(Controleur controleur) throws FileNotFoundException {
        commandeGetEtat = controleur.commandeGetEtat();
        myButton = new Button[commandeGetEtat.exec().length];
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            myButton[i] = new Button();
            myButton[i].setMinSize(80,80);
            gridPane.add(myButton[i],i,0);
        }
        dessine();
    }

    public void dessine() {
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            myButton[i].setGraphic(new ImageView(chameau[commandeGetEtat.exec()[i]]));
        }
    }*/
}
