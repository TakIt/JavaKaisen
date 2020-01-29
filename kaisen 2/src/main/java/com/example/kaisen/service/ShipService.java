package com.example.kaisen.service;


import com.example.kaisen.Controller;
import com.example.kaisen.model.EnemyField;
import com.example.kaisen.model.Enemyplay;
import com.example.kaisen.model.PlayerField;
import com.example.kaisen.model.Result;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Random;

@Service
public class ShipService{

    private PlayerField myField;
    private PlayerField enemyField;

    private int turn;
    private Result result;

    private Random random=new Random();

    protected Controller controller;

    Model model;

    public void settingGame(int x,int y){
        this.turn=0;
        this.result= Result.none;

        myField=new PlayerField(Enemyplay.player);
        myField.setInfo(x,y, EnemyField.ship);
        System.out.println("play/"+x+y);

        enemyField= new PlayerField(Enemyplay.cpu);
        int enemyX=random.nextInt(5);
        int enemyY=random.nextInt(5);
        System.out.println(enemyX+","+enemyY);
        enemyField.setInfo(enemyX,enemyY,EnemyField.enemyShip);
    }

    public int update(int x,int y){


        turnCount();

        int enemyX=random.nextInt(5);
        int enemyY=random.nextInt(5);

        System.out.println("cpu/"+"y:"+enemyY+"x:"+enemyX);


            if (hitJudge(x, y, enemyField) && hitJudge(enemyX, enemyY, myField)) {
                myField.setInfo(enemyX, enemyY, EnemyField.breaked);
                enemyField.setInfo(x, y, EnemyField.breaked);
                result = Result.draw;
                return 1;
            } else if (hitJudge(x, y, enemyField) && !hitJudge(enemyX, enemyY, myField)) {
                myField.setInfo(enemyX, enemyY, EnemyField.attacked);
                enemyField.setInfo(x, y, EnemyField.breaked);
                result = Result.win;
                return 2;
            } else if (!hitJudge(x, y, enemyField) && hitJudge(enemyX, enemyY, myField)) {
                myField.setInfo(enemyX, enemyY, EnemyField.breaked);
                enemyField.setInfo(x, y, EnemyField.attacked);
                result = Result.lose;
                return 3;
            } else {
                myField.setInfo(enemyX, enemyY, EnemyField.attacked);
                enemyField.setInfo(x, y, EnemyField.attacked);
                controller.atack(model,x,y);
                return 0;
            }
    }
    boolean hitJudge(int x, int y, PlayerField field){
        return field.getInfo(x,y)==EnemyField.ship || field.getInfo(x,y)==EnemyField.enemyShip;
    }


    public void turnCount(){
        turn++;
    }

    public EnemyField[][] getMyField() {
        return myField.getField();
    }

    public EnemyField[][] getEnemyField() {
        return enemyField.getField();
    }

    public Result getResult() {
        return result;
    }

    public int getTurn() {
        return turn;
    }

}