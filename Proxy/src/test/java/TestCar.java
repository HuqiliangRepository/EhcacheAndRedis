import com.huqiliang.proxy.Car.Plan;
import com.huqiliang.proxy.Car.Train;
import com.huqiliang.proxy.factory.PlanFactory;
import com.huqiliang.proxy.factory.TrainFactory;
import com.huqiliang.proxy.factory.VehicleFactory;
import com.huqiliang.proxy.interf.Moveable;

/**
 * Created by root on 5/5/16.
 */
public class TestCar {
    public static void main(String[] args) {

/*
        Train train1=Train.getInstance();
        Train train2=Train.getInstance();

        if (train1==train2){
            System.out.println("是同一辆火车.......");
        }
        train1.run();*/
        VehicleFactory vehicleFactory=new TrainFactory();
        Moveable moveable =vehicleFactory.create();
     moveable.move();
    }
}
