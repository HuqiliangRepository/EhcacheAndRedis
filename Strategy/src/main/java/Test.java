/**
 * Created by root on 4/22/16.
 */
public class Test {
    public static void main(String[] args) {

      // int[] a={9,6,5,4,3,2};
      // DataSorter.print(a);


        Cat[] a={new Cat(9,9),new Cat(5,5),new Cat(3,3)};
       // Dog[] d={new Dog(7),new Dog(5),new Dog(3),new Dog(1)};
        DataSorter.sort(a);
        DataSorter.print(a);
    }

}
