package com.example.luyen_tap_1.service;

import com.example.luyen_tap_1.model.Human;
import com.example.luyen_tap_1.repository.IHumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HumanService implements IHumanService {
    @Autowired
    IHumanRepository humanRepository;

    @Override
    public List<Human> getHuman() {
        return humanRepository.getHuman();
    }

    @Override
    public boolean createHuman(Human human) {
        return humanRepository.createHuman(human);
    }

    @Override
    public boolean updateHuman(int id, Human human) {
        Human newHuman = findId(id);
        if (newHuman!=null){
            humanRepository.updateHuman(id,human);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteHuman(int id) {
        return humanRepository.deleteHuman(id);
    }

    @Override
    public List<Human> searchHuman(String name) {
        return humanRepository.searchHuman(name);
    }

    @Override
    public Human findId(int id) {
        List<Human> findHuman = humanRepository.getHuman();
        for (int i = 0; i < findHuman.size(); i++) {
            if (findHuman.get(i).getId()==id){
                return findHuman.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Human> findHuman(int id) {
        List<Human> findHuman = humanRepository.getHuman();
        List<Human> humanList = new ArrayList<>();
        for (int i = 0; i < findHuman.size(); i++) {
            if (findHuman.get(i).getId()==id){
                humanList.add(findHuman.get(i));
                return humanList;
            }
        }
        return null;
    }
}
