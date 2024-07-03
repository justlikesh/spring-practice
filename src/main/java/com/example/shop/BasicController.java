package com.example.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;

@Controller
public class BasicController {
    @GetMapping("/")
//    @ResponseBody //애노테이션 //요걸 추가해주면 return오른쪽에 있는 문자 그대로 보내주세요 라는 뜻 폴더로 리턴할땐 빼야함
    String hello(){
        return "index.html"; //static폴더가 기본폴더
    }
    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "피싱사이트에요";
    }
    @GetMapping("/mypage")
    @ResponseBody
    String mypage(){
        return "마이페이지 입니다.";
    }
    @GetMapping("/date")
    @ResponseBody
    String date(){
        return ZonedDateTime.now().toString();
    }

}
