package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//컨트롤러는 요청이 들어왔을때 처리하는 것
//우선 오른쪽 클릭 -> GoTo -> Test 만들어주기
@RestController
public class RestaurantController {
    // List 생성 -> 리스트 반환
    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = new ArrayList<>(); //왜 처음부터 ArrayList를 사용하지 않는거지?

        //Create Restaurant Instance
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");

        restaurants.add(restaurant);

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id/*URL에 있는 id 번수 */){

        List<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add( new Restaurant(2020L, "Cyber Food", "Seoul"));

        Restaurant restaurant = restaurants.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);

        return restaurant;
    }
}
