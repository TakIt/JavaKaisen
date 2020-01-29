package com.example.kaisen;

import com.example.kaisen.model.Resultinfo;
import com.example.kaisen.service.ShipService;
import com.example.kaisen.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    ShipService ShipService;
    @Autowired
    ResultService resultService;

    @GetMapping("HomePage")
    public String get(Model model){
        return "HomePage.html";
    }
    @PostMapping("HomePage")
    public String post(Model model,int width,int length){
        try {
            ShipService.settingGame(width, length);

            model.addAttribute("player", ShipService.getMyField());
            model.addAttribute("cpu", ShipService.getEnemyField());
        }catch (Exception e){
            return "HomePage.html";
        }
        return "atack.html";
    }
    @PostMapping("atack")
    public String  atack(Model model,int width,int length) {

        try {
            int judge = ShipService.update(width, length);


            model.addAttribute("player", ShipService.getMyField());
            model.addAttribute("cpu", ShipService.getEnemyField());
            if (judge == 2) {
                return "Win.html";
            } else if (judge == 3) {
                return "Los.html";
            } else if (judge == 1) {
                return "Draw.html";
            } else if (judge==0){
                return "atack.html";
            }
        }
            catch(Exception e){
                return "atack.html";
            }
        return "HomePage.html";
    }

    @PostMapping("Result")
    public String result(Model model){
        List<Resultinfo> previousResults=resultService.findAll();
        model.addAttribute("previousResults",previousResults);
        resultService.register(ShipService.getResult(),ShipService.getTurn());
        model.addAttribute("result",ShipService.getResult().toString()+":"+ShipService.getTurn()+"手目");

        return "result";
    }

}