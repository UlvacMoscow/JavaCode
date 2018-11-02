import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by арсений on 16.11.2017.
 */
public class Loader {
    public static void main(String[] args) throws IOException {

        Truck truck = new Truck();

        System.out.println("Type, amount boxs");
        int amountBoxs = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());

        truck.setAmountTruck(amountBoxs / 324.);
        System.out.println(truck.getAmountTruck());
        if (truck.getAmountTruck() < 0) {
            truck.setAmountTruck(1);
        } else if (truck.getAmountTruck() == Math.floor(amountBoxs / 324.)) {
            truck.setAmountTruck(Math.floor(amountBoxs / 324.));
        } else {
            truck.setAmountTruck(truck.getAmountTruck() + 1);
        }
        truck.setAmountTruck((int) truck.getAmountTruck());

        System.out.println("We need trucks " + truck.getAmountTruck());
        System.out.println(truck.getAmountTruck());

        for (int k = 1; k <= truck.getAmountTruck(); k++) {
            System.out.println("Truck number " + k);


            for (int i = 1; i <= Truck.AMOUNT_CONTAINET_OF_TRUCK; i++) {
                if (truck.getBox() < amountBoxs) {
                    System.out.println("conteiner number " + i);
                }
                for (int j = 1; j <= Truck.AMOUNT_BOX_OF_CONTAINER; j++) {
                    if (amountBoxs == truck.getBox()) {
                        break;
                    }
                    truck.setBox(truck.getBox() + 1);
                    System.out.println("box number " + j);
//                    System.out.println(truck.getBox());
//        int[][][] truck = new int[12][27][(int) x];
                }


            }
        }


    }
}
