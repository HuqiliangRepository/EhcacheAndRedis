package com.huqiliang.proxy.factory;

import com.huqiliang.proxy.Car.Plan;
import com.huqiliang.proxy.Car.Train;
import com.huqiliang.proxy.interf.Moveable;

/**
 * Created by root on 5/5/16.
 */
public class TrainFactory extends VehicleFactory{


    @Override
   public Moveable create() {
        return new Train();
    }
}
