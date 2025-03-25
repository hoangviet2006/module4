package com.example.demo_bai_3.repository;

import com.example.demo_bai_3.model.Human;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HumanRepository implements IHumanRepository {
    private static List<Human> humanList = new ArrayList<>();
    static {
        humanList.add(new Human(1,"Việt","2006-03-30","nam","0123456789","Huế","Học sinh","Việt Nam","https://images.pexels.com/photos/842711/pexels-photo-842711.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        humanList.add(new Human(2,"Đạt","1998-02-28","nam","0987456123","Nghệ An","Làm Onl","Việt Nam","https://images.pexels.com/photos/1183099/pexels-photo-1183099.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
        humanList.add(new Human(3,"Quốc","2000-02-28","nam","0147252839","Đà Nẵng","Thất Nghiệp","Việt Nam","https://images.pexels.com/photos/24449015/pexels-photo-24449015/free-photo-of-view-of-mountains.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"));
    }
    @Override
    public List<Human> getHuman() {
        return humanList;
    }

    @Override
    public boolean createHuman(Human human) {
      return humanList.add(human);
    }

    @Override
    public boolean updateHuman(int id, Human human) {
        for (int i = 0; i < humanList.size(); i++) {
            if (humanList.get(i).getId()==id){
                humanList.set(i,human);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteHuman(int id) {
        for (int i = 0; i < humanList.size(); i++) {
            if (humanList.get(i).getId()==id){
                humanList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Human> searchHuman(String name) {
        List<Human> newHuman = new ArrayList<>();
        for (int i = 0; i < humanList.size(); i++) {
            if (humanList.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                newHuman.add(humanList.get(i));
            }
        }
        return newHuman;
    }


}
