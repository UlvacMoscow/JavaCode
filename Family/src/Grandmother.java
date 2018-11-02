import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by арсений on 19.10.2017.
 */
public class Grandmother extends Relative{

    @Override
    public void Alive() {
        System.out.println("I am a grandmother and I am alive");
    }

    @Override
    public boolean ComeHome() {
        System.out.println("I am a grandmother and I don't come home");
        return false;
    }

    @Override
    public String IAmHere() {

        return "I am a grandmother and I am here";
    }


    public  void WhoIAm()    {
        System.out.println("I am a grandmother");
    }
}
