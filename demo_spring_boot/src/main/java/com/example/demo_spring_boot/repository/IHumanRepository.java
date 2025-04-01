package com.example.demo_spring_boot.repository;

import com.example.demo_spring_boot.model.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IHumanRepository extends JpaRepository<Human,Integer> {
List<Human> findHumanByNameContaining(String name);

}
