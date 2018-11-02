import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by арсений on 16.11.2017.
 */
public class Loader {
    public static void main(String[] args) {
        double a = 24.0;
        double b = 0.1;
        double c;
        c = 24.0* 0.1;
        double d = 24.0/10;


        System.out.println(c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
        System.out.println("Byte max " + Byte.MAX_VALUE);
        System.out.println("Byte min " + Byte.MIN_VALUE);
        System.out.println("Integer max " + Integer.MAX_VALUE);
        System.out.println("Integer min " + Integer.MIN_VALUE);
        System.out.println("Double max " + Double.MAX_VALUE);
        System.out.println("Double min " + Double.MIN_VALUE);
        System.out.println("Long max " + Long.MAX_VALUE);
        System.out.println("Long min " +Long.MIN_VALUE);
        System.out.println("Short max " +Short.MAX_VALUE);
        System.out.println("Short min " +Short.MIN_VALUE);
        System.out.println("Float max " +Float.MAX_VALUE);
        System.out.println("Float min " +Float.MIN_VALUE);

    }
}
