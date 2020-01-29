package com.example.kaisen.repository;

import com.example.kaisen.model.Resultinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.springframework.jdbc.core.BeanPropertyRowMapper.newInstance;

@org.springframework.stereotype.Repository
public class ResultRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public void insert(Resultinfo result){
        var sql="insert into RESULT values(?,?)";
        jdbc.update(sql,result.getResult().toString(),result.getTurn());
    }

    public List<Resultinfo> select(){
        var sql="SELECT RESULT, TURN  FROM RESULT";
        return  jdbc.query(sql,newInstance(Resultinfo.class));
    }
}
