package com.example.bai_4_baitap1.repository;

import com.example.bai_4_baitap1.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository {
    private static List<Email> emailList = new ArrayList<>();
    static {
        emailList.add(new Email("English","25",true,"viet"));
    }

}
