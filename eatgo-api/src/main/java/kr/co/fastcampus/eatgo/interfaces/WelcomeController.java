package kr.co.fastcampus.eatgo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //REST API 쓰기 위함
public class WelcomeController {

    @GetMapping("/") //http 접속을 위한 네가지 메소드 중 하나 , /는 접속하고 바로
    public String hello() {
        return "Hello, world!!!";
    }
}
