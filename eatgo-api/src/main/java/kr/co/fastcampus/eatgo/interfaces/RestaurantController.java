package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import org.apache.catalina.util.ErrorPageSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//컨트롤러는 요청이 들어왔을때 처리하는 것
//우선 오른쪽 클릭 -> GoTo -> Test 만들어주기
@RestController
public class RestaurantController {
    private RestaurantRepository repository = new RestaurantRepository(); //RestaurantRepository 인스턴스 추가

    // List 생성 -> 리스트 반환
    @GetMapping("/restaurants")
    public List<Restaurant> list(){

        List<Restaurant> restaurants = repository.findAll(); //repository의 전부를 얻는다.

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id/*URL에 있는 id 번수 */){

        Restaurant restaurant = repository.findnyId(id); //repository의 전부를 얻는다.

        return restaurant;
    }
}
