package com.example.blog.logger;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class logger {
    private static int count =0;
//    @After("execution(* com.example.blog.controller.BlogController.search(..))")
//    public void CountAccess(){
//        System.out.println("Số lần truy cập method search trong BlogController");
//        count++;
//        System.out.println("------------------");
//        System.out.println("Số Lần: "+ count);
//    }
//    @AfterThrowing("execution(* com.example.blog.service.BlogService.addBlog(..))")
//    public void exception(){
//        System.out.println("---------------");
//        System.out.println("Tên trùng với admin");
//    }
//
    @Around("execution(* com.example.blog.service.BlogService.addBlog(..))")
    public Object check(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("-------------------------------------------------");
        System.out.println("Công việc thực hiện trước");
        Object o= null;
        try {
            o = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Công việc thực sau");
        return o;
    }
}
