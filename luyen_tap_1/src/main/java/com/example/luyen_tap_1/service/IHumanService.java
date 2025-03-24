package com.example.luyen_tap_1.service;

import com.example.luyen_tap_1.model.Human;

import java.util.List;

public interface IHumanService {
    List<Human> getHuman();
    boolean createHuman(Human human);
    boolean updateHuman(int id,Human human);
    boolean deleteHuman(int id);
    List<Human> searchHuman(String name);
    Human findId(int id);
    List<Human> findHuman(int id);
}
