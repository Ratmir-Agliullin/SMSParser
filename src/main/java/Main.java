import java.io.IOException;

/**
 * Created by Аглиуллины on 06.10.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        parser.SmsActivate();
        parser.SmsVK();
        parser.SmsLike();
        Service.writeStringInFile(parser.globalArray.toString());
    }
}
