package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //spring을 통해서 이 test를 실행 할 수 있도록 하기
//restaurant 컨트롤러를 테스트한다는것을 명시
@WebMvcTest(RestaurantController.class) //제데로된 저장소 사용 불가능 -> 의존성 주입해줘야 함
public class RestaurantControllerTest {

    @Autowired //spring에서 알아서 넣어줄 수 있도록 , 다음에 더 자세히 알아볼 것
    private MockMvc mvc;

    @SpyBean //테스트를 실행할 때 이것을 사용하겠다! : 의존성 주입
    //의존성주입 장점: 우리가 사용하려는 객체를 자유롭게 변경 가능
    //repository 를 인터페이스로 변경하고 만들었던부분을 실제 구현으로 만들기
    private RestaurantRepository restaurantRepository;

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

    //가게 상세
    @Test
    public void detail() throws Exception {
        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")));
        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":2020")))
                .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")));

    }

}