import java.io.*;
import java.util.ArrayList;

public class WriterFile {

    public WriterFile() {

    }

    final String fiLeName1 = "tmp.txt";
    public void tmpWriter(String data) {//tmp.txt dosyasına veri yazdırma
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fiLeName1, true));
            writer.write(data);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println("tmp.txt dosyasına veri yazılırken sıkıntı çıktı.");
        }
    }

    final String fiLeName2 = "out.txt";
    public void outWriter(ArrayList<WordNode> data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fiLeName2));
            for (WordNode walk : data) {
                while (walk != null) {
                    writer.write("Word: " + walk.getWord() + ", Freq: " + walk.getFreq());
                    writer.newLine();
                    walk = walk.getNext();
                }
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("tmp.txt dosyasına veri yazılırken sıkıntı çıktı.");
        }
    }
}
