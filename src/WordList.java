import java.util.ArrayList;//effective java araştır
import java.util.Scanner;

public class WordList {
    Scanner scanner = new Scanner(System.in);

    public WordList() {

    }

    ArrayList<WordNode> mainArrayList = new ArrayList<>();
    public void createArrayList() {// mainArrayList' e 26 tane değer atadım
        WordNode node = new WordNode("");
        for (int i = 0; i < 26; i++) {
            mainArrayList.add(node);
        }
    }

    ArrayList<WordNode> top10 = new ArrayList<>();
    public void createArrayList2(ArrayList<WordNode> arrayList) {
        WordNode node = new WordNode("doftdare", 0);
        for (int i = 0; i < 10; i++) {
            arrayList.add(node);
        }
    }

    public String loverCaseOperation(String str) {//kelimeleri küçülttüm
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'I' || str.charAt(i) == 'İ') {
                result += "i";
            } else {
                result += str.toLowerCase().charAt(i);
            }
        }
        return result;
    }

    public void updateTop10(WordNode node, ArrayList<WordNode> arrayList) {
        int min = arrayList.get(0).getFreq();
        WordNode box = arrayList.get(0);
        for (WordNode wordNode : arrayList) {//gelen arrayliste bulunan en küçük frequence değeri min' e atadım

            if (wordNode.getFreq() < min) {
                min = wordNode.getFreq();
                box = wordNode;
            }
        }

        if (node.getFreq() > min) {
            int index = arrayList.indexOf(box);

            arrayList.set(index, node);
        }
    }

    public void getTop10WordWithHighestFreq() {

        createArrayList2(top10);

        for (int i = 0; i < 26; i++) {
            WordNode walk = mainArrayList.get(i);

            while (walk != null) {

                updateTop10(walk, top10);
                walk = walk.getNext();
            }
        }

        printTop10(arrangementTop10(top10));
    }

    public ArrayList<WordNode> arrangementTop10(ArrayList<WordNode> top10) {
        ArrayList<WordNode> newTop10 = new ArrayList<>();
        int max = 0;
        WordNode box = null;

        for (int i = 0; i < 10; i++) {
            for (WordNode wordNode : top10) {
                if (wordNode.getFreq() > max && !newTop10.contains(wordNode)) {
                    max = wordNode.getFreq();
                    box = wordNode;
                }
            }
            max = 0;
            newTop10.add(box);
        }

        return newTop10;
    }

    public void printTop10(ArrayList<WordNode> top10) {
        for (WordNode wordNode: top10) {
            System.out.println(wordNode.getFreq() + " = " + wordNode.getWord());
        }
    }

    public void returnStr(ArrayList<String> newArray) {//dosyadan gelen değerleri tek tek arrayliste linkedlist olarak ekledim
        for (String str : newArray) {
            add(str);
        }
    }

    public void add(String word) {
        String newWord = loverCaseOperation(word);//kelimeyi küçülttüm
        int letterOrder = getIndex(newWord);

        if (!contains(newWord)) {

            WordNode newNode = new WordNode(newWord);

            if (mainArrayList.get(letterOrder) != null) {
                newNode.setNext(mainArrayList.get(letterOrder));
            }
            mainArrayList.set(letterOrder, newNode);
        }
    }

    public boolean contains(String str) {
        WordNode walk = mainArrayList.get(getIndex(str));

        while (walk != null) {
            if (walk.getWord().equals(str)) {
                int freq = walk.getFreq();
                walk.setFreq((freq + 1));
                return true;
            }
            walk = walk.getNext();
        }
        return false;
    }

    public int getIndex(String str) {

        char check = loverCaseOperation(str).charAt(0);
        int box;
        switch (check) {
            case 'a':
                box = 0;
                break;
            case 'b':
                box = 1;
                break;
            case 'c':
                box = 2;
                break;
            case 'd':
                box = 3;
                break;
            case 'e':
                box = 4;
                break;
            case 'f':
                box = 5;
                break;
            case 'g':
                box = 6;
                break;
            case 'h':
                box = 7;
                break;
            case 'i':
                box = 8;
                break;
            case 'j':
                box = 9;
                break;
            case 'k':
                box = 10;
                break;
            case 'l':
                box = 11;
                break;
            case 'm':
                box = 12;
                break;
            case 'n':
                box = 13;
                break;
            case 'o':
                box = 14;
                break;
            case 'p':
                box = 15;
                break;
            case 'q':
                box = 16;
                break;
            case 'r':
                box = 17;
                break;
            case 's':
                box = 18;
                break;
            case 't':
                box = 19;
                break;
            case 'u':
                box = 20;
                break;
            case 'v':
                box = 21;
                break;
            case 'w':
                box = 22;
                break;
            case 'x':
                box = 23;
                break;
            case 'y':
                box = 24;
                break;
            case 'z':
                box = 25;
                break;
            default:
                box = 26;//yanlış değerler için
                break;
        }
        return box;
    }

    public void research() {
        String str, data;
        boolean result = false;

        System.out.print("Please enter the word you want to search: ");
        data = scanner.next();
        str = loverCaseOperation(data);

        WordNode walk = mainArrayList.get(getIndex(str));

        while (walk != null) {
            if (walk.getWord().equals(str)) {
                System.out.println(walk.getWord() + " = " + walk.getFreq());
                result = true;
            }
            walk = walk.getNext();
        }

        if (!result) {
            System.out.println("Word not found...");
        }
    }

    public void writer() {
        WriterFile writerFile = new WriterFile();
        writerFile.outWriter(mainArrayList);
    }
}