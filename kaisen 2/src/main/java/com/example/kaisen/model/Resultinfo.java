package com.example.kaisen.model;

public class Resultinfo {
    private int turn;
    private Result result;


    public Resultinfo(Result result, int turn) {
        this.result = result;
        this.turn = turn;
    }


    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}