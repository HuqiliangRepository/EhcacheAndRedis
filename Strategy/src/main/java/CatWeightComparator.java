/**
 * Created by root on 4/26/16.
 */
public class CatWeightComparator implements Comparator {
    public int compara(Object o1, Object o2) {

        Cat c1 = (Cat) o1;
        Cat c2 = (Cat) o2;

        if (c1.getWeight() > c2.getWeight()) {

            return 1;
        }else if (c1.getWeight()<c2.getWeight()) {
            return -1;
        }else return 0;

    }

}
