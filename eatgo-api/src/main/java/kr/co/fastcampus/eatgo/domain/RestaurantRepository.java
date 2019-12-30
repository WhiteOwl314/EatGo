package kr.co.fastcampus.eatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    public List<Restaurant> findAll() {
        List<Restaurant> restaurants = new ArrayList<>(); //왜 처음부터 ArrayList를 사용하지 않는거지?

        //Create Restaurant Instance
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
        restaurants.add( new Restaurant(2020L, "Cyber Food", "Seoul"));

        restaurants.add(restaurant);

        return restaurants;
    }
}
