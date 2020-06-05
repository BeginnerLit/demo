package com.example.demo;

import lombok.Data;
@Data
public class Tuple<ONE,TWO> {
    private ONE one;
    private TWO two;

    public Tuple(ONE a, TWO i) {
        one=a;
        two=i;
    }

    public ONE getOne() {
        return one;
    }

    public TWO getTwo() {
        return two;
    }

    public void setOne(ONE one) {
        this.one = one;
    }

    public void setTwo(TWO two) {
        this.two = two;
    }

}
