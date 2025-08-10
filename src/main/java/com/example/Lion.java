
package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;

    private final Predator predator;

    public Lion(Predator predator) {
        this.predator = predator;
    }

    public Lion(String sex, Predator predator) throws Exception {
        if (!"Самец".equals(sex) && !"Самка".equals(sex)) {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
        this.predator = predator;
        this.hasMane = "Самец".equals(sex);
    }


    public int getKittens() {
        return predator.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
       return predator.eatMeat();
    }
}
