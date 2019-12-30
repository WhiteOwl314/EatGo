package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//컨트롤러는 요청이 들어왔을때 처리하는 것
//우선 오른쪽 클릭 -> GoTo -> Test 만들어주기
@RestController //Component의 일종
public class RestaurantController {

    //Repository를 여기서 할당해주고 있는데 이번에 다른 곳으로 옮길 것
    @Autowired //Controller를 만들어줄 때 스프링이 알아서 생성해서 넣어줌
   private RestaurantRepositoryImpl repository;

    // List 생성 -> 리스트 반환
    @GetMapping("/restaurants")
    public List<Restaurant> list(){

        List<Restaurant> restaurants = repository.findAll(); //repository의 전부를 얻는다.

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id/*URL에 있는 id 번수 */){

        Restaurant restaurant = repository.findmyId(id); //repository의 전부를 얻는다.

        return restaurant;
    }
}
