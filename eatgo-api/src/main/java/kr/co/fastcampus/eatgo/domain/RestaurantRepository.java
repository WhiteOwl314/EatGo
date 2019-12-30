package kr.co.fastcampus.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component //Spring 이 관리할 수 있도록 -> 이 클래스를 사용하는 곳에서 @Autowired를 해주면
public class RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepository(){
        restaurants.add( new Restaurant(2020L, "Cyber Food", "Seoul"));
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
    }
    public List<Restaurant> findAll() {
        return restaurants;
    }

    public Restaurant findmyId(Long id) {
       return restaurants.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }
}
