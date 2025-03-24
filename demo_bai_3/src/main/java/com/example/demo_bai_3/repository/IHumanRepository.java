package com.example.demo_bai_3.repository;

import com.example.demo_bai_3.model.Human;

import java.util.List;

public interface IHumanRepository {
    List<Human> getHuman();

    boolean createHuman(Human human);

    boolean updateHuman(int id, Human human);

    boolean deleteHuman(int id);

    List<Human> searchHuman(String name);

}
