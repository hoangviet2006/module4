package com.example.demo_bai_3.service;

import com.example.demo_bai_3.model.Human;

import java.util.List;

public interface IHumanService {
    List<Human> getHuman();
    boolean createHuman(Human human);
    boolean updateHuman(int id,Human human);
    boolean deleteHuman(int id);
    List<Human> searchHuman(String name);
    Human findId(int id);
   Human findHuman(int id);
}
