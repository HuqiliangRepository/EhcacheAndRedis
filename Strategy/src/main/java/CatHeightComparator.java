/**
 * Created by root on 4/26/16.
 */
public class CatHeightComparator implements Comparator {
    public int compara(Object o1, Object o2) {

        Cat c1 = (Cat) o1;
        Cat c2 = (Cat) o2;

        if (c1.getHeight() > c2.getHeight()) {

            return 1;
        }else if (c1.getHeight()<c2.getHeight()) {
            return -1;
        }else return 0;

    }
}
