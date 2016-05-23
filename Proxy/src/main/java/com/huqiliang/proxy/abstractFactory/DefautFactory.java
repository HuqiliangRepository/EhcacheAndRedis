package com.huqiliang.proxy.abstractFactory;

/**
 * Created by root on 5/9/16.
 */
public class DefautFactory {
   public Car createCar(){
        return new Car();

    }
    public AK47 createAK47(){
        return new AK47();
    }
    public Apple createApple(){

        return new Apple();
    }
}
