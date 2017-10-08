import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Аглиуллины on 08.10.2017.
 */
public class Service {
    public static void writeStringInFile(String in) throws IOException {

        BufferedWriter myfile = new BufferedWriter(new FileWriter("src/main/java/buffer.dat"));
        myfile.write(in);
        myfile.close();
    }


}
