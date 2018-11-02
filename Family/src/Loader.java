/**
 * Created by арсений on 19.10.2017.
 */
public class Loader {
    public static void main(String[] args) {

        Mother mom1 = new Mother();

        mom1.WhoIAm();

        Grandmother bab1 = new Grandmother();

        bab1.WhoIAm();
        bab1.IAmHere();

        Grandmother mom2 = new Mother();

        mom2.WhoIAm();
        mom1.GoWork();

        Daughter len = new Daughter();
        len.GoWork();
        len.WhoIAm();

        Grandmother len2 = new Daughter();

        len2.WhoIAm();
        len2.IAmHere();

//        Grandfather ded1 = new Grandfather();
//        ded1.ComeHome();
    }
}
