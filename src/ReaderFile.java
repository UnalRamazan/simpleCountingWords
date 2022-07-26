import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReaderFile {

    WriterFile writer = new WriterFile();
    ArrayList<String> strValues = new ArrayList<>();

    public ReaderFile() {

    }

    final String fileName1 = "input.txt";
    public void inputReader() {//input.txt dosyasından veri çekme
        try {
            String line;
            String newArray = "";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));

            while ((line = bufferedReader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if ((line.charAt(i) <= 'Z' && line.charAt(i) >= 'A') || (line.charAt(i) <= 'z' && line.charAt(i) >= 'a')) {
                        newArray += line.charAt(i);
                    } else {
                        newArray += " ";
                    }
                }

                writer.tmpWriter(newArray);
                newArray = "";
            }
        } catch (Exception e) {
            System.out.println("Input.txt dosyası okunurken sıkıntı çıktı...");
        }
    }

    final String fileName2 = "tmp.txt";
    public ArrayList<String> tmpReader() {//tmp.txt dosyasından veri çekme
        int counter = 0;

        try {
            int i, k;
            String line;
            String value = "";//dosya içindeki değerleri tutmak için
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName2));

            while ((line = bufferedReader.readLine()) != null) {//her satırın başındaki boşlukları atladım
                for (k = 0; k < line.length(); k++) {
                    if (line.charAt(k) != ' ') {
                        break;
                    }
                }

                for (i = k; i < line.length(); i++) {
                    if (line.charAt(i) != ' ') {
                        value += line.charAt(i);

                    } else if (line.charAt(i) == ' ' && value.length() != 0) {
                        strValues.add(value);
                        value = "";

                    } else if (i == (line.length() - 1) && value.length() != 0) {
                        value += line.charAt(i);
                        strValues.add(value);
                        value = "";
                    }
                }
                counter++;
            }
        } catch (Exception e) {
            System.out.println("tmp.txt dosyası okunurken sıkıntı çıktı..." + counter);
        }

        return strValues;
    }
}
