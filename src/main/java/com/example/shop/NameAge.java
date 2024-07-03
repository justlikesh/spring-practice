package com.example.shop;


import lombok.Getter;
import lombok.Setter;

import static org.apache.coyote.http11.Constants.a;

@Getter
@Setter
public class NameAge {
    private String name;
    private int age;

    public void 한살더하기() {
        this.age = this.age + 1;
    }

    public void 나이설정(int a) {
        if(a > 0 && a < 100){

        this.age = a;}
    }
}
