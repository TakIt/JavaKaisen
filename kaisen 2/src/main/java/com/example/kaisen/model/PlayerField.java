package com.example.kaisen.model;

public class PlayerField {
    private Enemyplay name;
    private EnemyField[][] field;

    public PlayerField(Enemyplay name){
        this.name=name;

        field =new EnemyField[5][5];
        for(int j=0;j<5;j++) {
            for(int i=0;i<5;i++) {
                this.field[i][j]=EnemyField.empty;
            }
        }
    }

    public void setInfo(int x,int y,EnemyField fieldInfo){
        this.field[x][y]=fieldInfo;
    }
    public EnemyField getInfo(int x,int y){
        return this.field[x][y];
    }

    public EnemyField[][] getField() {
        return field;
    }

    public Enemyplay getName() {
        return name;
    }
}
