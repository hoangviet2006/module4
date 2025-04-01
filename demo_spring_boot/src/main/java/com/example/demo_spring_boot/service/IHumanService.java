package com.example.demo_spring_boot.service;

import com.example.demo_spring_boot.model.Human;

import java.util.List;

public interface IHumanService {
    List<Human> getHuman();
    void createHuman(Human human);
    boolean updateHuman(int id,Human human);
    boolean deleteHuman(int id);
    List<Human> searchHuman(String name);
    Human findId(int id);
   List<Human> findHuman(String name);
}
