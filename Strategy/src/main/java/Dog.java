/**
 * Created by root on 4/26/16.
 */
public class Dog implements Comparable{
    private int food;

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public Dog(int food) {

        this.food = food;
    }

    public int comparaTo(Object o) {
        if (o instanceof Dog) {
            Dog d= (Dog) o;
            if (this.getFood() > d.getFood()) {
                return 1;
            }else if (this.getFood()<d.getFood())
            {
                return -1;
            }else{ return 0;}

        }
        return -100;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "食物=" + food +
                '}';
    }
}
