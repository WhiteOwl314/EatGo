package kr.co.fastcampus.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTests {

    @Test //test로 실행하겠다
    public void creation() {
        Restaurant restaurant = new Restaurant("Bob zip", "Seoul");
        //잘못된 테스트 예시
        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getaddress(),is("Seoul"));
    }

    //상세정보 출력되게끔
    @Test
    public void information(){
        Restaurant restaurant = new Restaurant("Bob zip", "Seoul");

        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
    }



}