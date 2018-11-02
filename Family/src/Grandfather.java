/**
 * Created by арсений on 19.10.2017.
 */
public class Grandfather extends Relative {
    @Override
    public void Alive() {
        System.out.println("I am a Grandfather and I am alive");
    }

    @Override
    public boolean ComeHome() {
        System.out.println("I am a Grandfather and I come home");
        return true;
    }

    @Override
    public String IAmHere() {
        return "I am a Grandfather and I stay at home";
    }
}
