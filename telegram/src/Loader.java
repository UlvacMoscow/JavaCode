import com.sun.org.apache.xpath.internal.SourceTree;
import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthCheckedPhone;
import org.javagram.response.AuthSentCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by арсений on 13.10.2017.
 */
public class Loader {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        TelegramApiBridge bridge = new TelegramApiBridge("149.154.167.50:443",125211,"a984668637154f1f276efe6a7841d7d0");

        System.out.println("Please, type number phone");
        String telefon = reader.readLine().trim();
        AuthCheckedPhone checkedPhone = bridge.authCheckPhone(telefon);
        System.out.println(checkedPhone.isRegistered());

        System.out.println("111111111111111111111111111111111111111111111111111111111111111111111");
        bridge.authSendCode(telefon);
        System.out.println("111111111111111111111111111111111111111111111111111111111111111111111");
        System.out.println("Please, type smscode");
        System.out.println("111111111111111111111111111111111111111111111111111111111111111111111");
        String code = reader.readLine().trim();
        AuthAuthorization authAuthorization = bridge.authSignIn(code);
        System.out.println("111111111111111111111111111111111111111111111111111111111111111111111");
        System.out.println("name surname" + authAuthorization.getUser());

    }


}
