package com.example.kaisen.service;

import com.example.kaisen.model.Result;
import com.example.kaisen.repository.ResultRepository;
import com.example.kaisen.model.Resultinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;

import java.util.List;

@Service
public class ResultService {
    private List<Resultinfo> results;

    @Autowired
     ResultRepository repository;

    public void register(Result eResult, int turn){
        Resultinfo result=new Resultinfo(eResult,turn);
        try {
            repository.insert(result);
        }
        catch (DataAccessException e){
            e.printStackTrace();
        }
    }


    public List<Resultinfo> findAll(){
        try{
            return repository.select();
        }
        catch (DataAccessException e) {
            e.printStackTrace();
        }
        return emptyList();
    }
}