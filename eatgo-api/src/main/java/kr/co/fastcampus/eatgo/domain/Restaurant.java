package kr.co.fastcampus.eatgo.domain;

// 오른쪽 클릭 -> Go to -> Test -> create new test -> 생성
public class Restaurant {
    private final String name;
    private final String address;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public String getInformation() {
        return name + " in " +address;
    }

    public String getaddress() {
        return address;
    }
}
