package com.aaa.group8.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ErChartsDao {

    List<Map> getData(Map map);
}


