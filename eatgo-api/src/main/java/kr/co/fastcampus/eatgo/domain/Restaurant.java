package kr.co.fastcampus.eatgo.domain;

// 오른쪽 클릭 -> Go to -> Test -> create new test -> 생성
public class Restaurant {
    private final Long id;
    private final String name;
    private final String address;

    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }


    public Long getId() {
        return id;
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
