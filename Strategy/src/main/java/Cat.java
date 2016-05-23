/**
 * Created by root on 4/25/16.
 */
public class Cat implements Comparable{

    private int height;
    private int weight;
 //   private Comparator comparator=new CatHeightComparator();
    private Comparator comparator=new CatWeightComparator();

    public Comparator getComparator() {
        return comparator;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    public Cat(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "高度=" + height +
                ", 体重=" + weight +
                '}';
    }




    public int comparaTo(Object o) {
  /*      if (o instanceof Cat) {
            Cat c=(Cat)o;
            if (this.getHeight()>((Cat) o).getHeight()) {
                return 1;
            }else if (this.getHeight()<((Cat) o).getHeight()){
                return -1;
            }else return 0;

        }*/
        return comparator.compara(this,o);


        //return -100;
    }
}
