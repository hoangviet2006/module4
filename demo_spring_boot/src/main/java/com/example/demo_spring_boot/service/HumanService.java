package com.example.demo_spring_boot.service;

import com.example.demo_spring_boot.model.Human;
import com.example.demo_spring_boot.repository.IHumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanService implements IHumanService {
    @Autowired
    IHumanRepository humanRepository;

    @Override
    public List<Human> getHuman() {
        return humanRepository.findAll();
    }

    @Override
    public void createHuman(Human human) {
        humanRepository.save(human);
    }

    @Override
    public boolean updateHuman(int id, Human human) {
        Human human1 = findId(id);
        if (human1!=null){
            human1.setName(human.getName());
            human1.setAddress(human.getAddress());
            human1.setDate(human.getDate());
            human1.setGender(human.getGender());
            human1.setPhoneNumber(human.getPhoneNumber());
            human1.setNationality(human.getNationality());
            human1.setJob(human.getJob());
            human1.setUrlImg(human.getUrlImg());
        }
        humanRepository.save(human1);
        return true;
    }

    @Override
    public boolean deleteHuman(int id) {
        humanRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Human> searchHuman(String name) {
        return humanRepository.findHumanByNameContaining(name);
    }

    @Override
    public Human findId(int id) {
        return humanRepository.findById(id).orElse(null);
    }

    @Override
    public List<Human> findHuman(String name) {
        List<Human> findHuman = humanRepository.findHumanByNameContaining(name);
        return findHuman;
    }
}
