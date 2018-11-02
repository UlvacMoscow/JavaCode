/**
 * Created by арсений on 16.11.2017.
 */
public class Truck {

    double amountTruck;
    int box = 0;

    final static int AMOUNT_CONTAINET_OF_TRUCK = 12;
    final static int AMOUNT_BOX_OF_CONTAINER = 27;
//        int amountBoxs;

    public double getAmountTruck() {
        return amountTruck;
    }

    public void setAmountTruck(double amountTruck) {
        this.amountTruck = amountTruck;
    }

    public static int getAmountContainetOfTruck() {
        return AMOUNT_CONTAINET_OF_TRUCK;
    }

    public static int getAmountBoxOfContainer() {
        return AMOUNT_BOX_OF_CONTAINER;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }
}
