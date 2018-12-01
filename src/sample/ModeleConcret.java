package sample;

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

public class ModeleConcret implements Modele {
    static int x;
    static int y;
    public static int[][] map = new int[][]{
        {2,2,2,2,2,2,2,2,2,2},
        {2,4,3,1,1,2,4,3,1,2},
        {2,1,1,1,1,2,2,2,1,2},
        {2,2,2,1,5,1,1,1,1,2},
        {2,1,1,1,1,1,2,2,2,2},
        {2,4,3,1,1,1,1,3,4,2},
        {2,2,2,2,2,2,2,2,2,2},
        {1,1,1,1,1,1,1,1,1,1}
    };
    public static int[][] map2 = new int[][]{
            {2,2,2,2,2,2,2,2,2,2},
            {2,4,3,1,1,2,4,3,1,2},
            {2,1,1,1,1,2,2,2,1,2},
            {2,2,2,1,5,1,1,1,1,2},
            {2,1,1,1,1,1,2,2,2,2},
            {2,4,3,1,1,1,1,3,4,2},
            {2,2,2,2,2,2,2,2,2,2},
            {1,1,1,1,1,1,1,1,1,1}
    };

    public static int[][] getEtat() {
        return map;
    }

    public void move(KeyCode code,String direction) {
        switch (code) {
            case UP:
                direction  = "top";
                //通道和目标点
                if (map[x-1][y]==1||map[x-1][y]==4) {
                    //1.将玩家当前位置还原
                    if (map2[x][y]==4) {
                        map[x][y] = 4;
                    }else {
                        map[x][y] = 1;
                    }
                    //3.将玩家移动过去
                    map[x-1][y] = 5;
                    //4.记录玩家的当前坐标
                    x-=1;
                   // drawMap(g2d);
                }
                //如果是箱子
                if (map[x-1][y]==3) {
                    //继续判断箱子的上边
                    //如果是通道或目标点
                    if (map[x-1-1][y]==1||map[x-1-1][y]==4) {
                        //移动玩家
                        if (map2[x][y]==4) {
                            map[x][y] = 4;
                        }else {
                            map[x][y] = 1;
                        }
                        //3.将玩家移动过去
                        map[x-1][y] = 5;
                        //4.记录玩家的当前坐标
                        x-=1;
                        //移动箱子
                        //1.将箱子当前的位子不需要还原
                        //3.移动箱子
                        map[x-1-1][y] = 3;
                       // win();
                    }
                }
                break;
            case DOWN:
                direction  = "bottom";
                //通道和目标点
                if (map[x+1][y]==1||map[x+1][y]==4) {
                    if (map2[x][y]==4) {
                        map[x][y] = 4;
                    }else {
                        map[x][y] = 1;
                    }
                    //3.将玩家移动过去
                    map[x+1][y] = 5;
                    //4.记录玩家的当前坐标
                    x+=1;
                    //drawMap();
                }
                //如果是箱子
                if (map[x+1][y]==3) {
                    //继续判断箱子的上边
                    //如果是通道或目标点
                    if (map[x+1+1][y]==1||map[x+1+1][y]==4) {
                        //移动玩家
                        if (map2[x][y]==4) {
                            map[x][y] = 4;
                        }else {
                            map[x][y] = 1;
                        }
                        //3.将玩家移动过去
                        map[x+1][y] = 5;
                        //4.记录玩家的当前坐标
                        x+=1;
                        //移动箱子
                        //1.将箱子当前的位子不需要还原
                        //3.移动箱子
                        map[x+1+1][y] = 3;
                        //win();
                    }
                }
                break;
            case LEFT:
                direction  = "left";
                //通道和目标点
                if (map[x][y-1]==1||map[x][y-1]==4) {
                    if (map2[x][y]==4) {
                        map[x][y] = 4;
                    }else {
                        map[x][y] = 1;
                    }
                    //3.将玩家移动过去
                    map[x][y-1] = 5;
                    //4.记录玩家的当前坐标
                    y-=1;
                    //drawMap(g2d);
                    break;
                }
                //如果是箱子
                if (map[x][y-1]==3) {
                    //继续判断箱子的上边
                    //如果是通道或目标点
                    if (map[x][y-1-1]==1||map[x][y-1-1]==4) {
                        //移动玩家
                        if (map2[x][y]==4) {
                            map[x][y] = 4;
                        }else {
                            map[x][y] = 1;
                        }
                        //3.将玩家移动过去
                        map[x][y-1] = 5;
                        //移动箱子
                        //1.将箱子当前的位子不需要还原
                        //3.移动箱子
                        map[x][y-1-1] = 3;
                        //4.记录玩家的当前坐标
                        y-=1;
                        //重画
                        //drawMap(g2d);
                       // win();
                    }
                }
                break;
            case RIGHT:
                direction  = "right";
                //通道和目标点
                if (map[x][y+1]==1||map[x][y+1]==4) {
                    if (map2[x][y]==4) {
                        map[x][y] = 4;
                    }else {
                        map[x][y] = 1;
                    }
                    //3.将玩家移动过去
                    map[x][y+1] = 5;
                    //4.记录玩家的当前坐标
                    y+=1;
                   // drawMap(g2d);
                    break;
                }
                //如果是箱子
                if (map[x][y+1]==3) {
                    //继续判断箱子的上边
                    //如果是通道或目标点
                    if (map[x][y+1+1]==1||map[x][y+1+1]==4) {
                        //移动玩家
                        if (map2[x][y]==4) {
                            map[x][y] = 4;
                        }else {
                            map[x][y] = 1;
                        }
                        //3.将玩家移动过去
                        map[x][y+1] = 5;

                        //移动箱子
                        //1.将箱子当前的位子不需要还原
                        //3.移动箱子
                        map[x][y+1+1] = 3;
                        //4.记录玩家的当前坐标
                        y+=1;
                       // drawMap(g2d);
                       // win();
                    }
                }
                break;
            default:
                break;
        }
    }


}


   /* public void reset() {
        etat =  new int[] {0,0,0,1,2,2,2};/*
    }
}*/
