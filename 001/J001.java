import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by PopePius on 14/12/16.
 */
public class J001 {
    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    public static void main(String[] args){
        try {
            URL url = new URL("http://deron.meranda.us/data/census-derived-all-first.txt");
            Scanner s = new Scanner(url.openStream());
            // read from your scanner
            ArrayList<String> names = new ArrayList<>();
            while (s.hasNextLine()) {
                String line = s.nextLine();
                names.add(line);
            }
            s.close();
            int random = getRandomNumberInRange(0,names.size());
            String nameLine = names.get(random);
            String[] split = nameLine.split("\\s+");
            System.out.println(split[0]);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
