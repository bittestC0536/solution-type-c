package problem04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileAppend {
    public void write_file(int correct_count, int discorrect_count, double result_time) {
        File file = new File("C:\\Users\\BIT\\Desktop\\result.txt");

        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write("걸린 시간 : ");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}