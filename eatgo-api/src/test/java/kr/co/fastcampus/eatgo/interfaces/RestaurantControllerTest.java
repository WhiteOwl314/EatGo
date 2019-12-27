package kr.co.fastcampus.eatgo.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //spring을 통해서 이 test를 실행 할 수 있도록 하기
//restaurant 컨트롤러를 테스트한다는것을 명시
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired //spring에서 알아서 넣어줄 수 있도록 , 다음에 더 자세히 알아볼 것
    private MockMvc mvc;

    //컨트롤러를 어떻게 테스트 할 지 알아보기
    @Test
    public void list() throws Exception {
        mvc.perform(get("/restaurants")) //mvc: create Field, get: import.
            .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":1004")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Bob zip\"")
                )); // 가게이름이 나오게 해야 함 .
        //요청하면 성공적인 결과가 나와야 함.
        //status : import, perform: throws 예외처
        //control + option + o -> 쓸데없는게 사라짐
        //content -> import MockMvc~
        //containsString -> import Stringcontains~
    }

}