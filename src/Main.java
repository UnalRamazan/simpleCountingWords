import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class MyThread extends Thread {
    int counter = 0;
    Timer myTimer = new Timer();
    TimerTask myTask = new TimerTask() {
        @Override
        public void run() {
            System.out.print("...");
            counter++;
            if (counter == 40) {
                myTimer.cancel();
            }
        }
    };

    public void run() {
        System.out.print("Downloading...");
        myTimer.schedule(myTask, 0, 5000);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReaderFile reader = new ReaderFile();
        WordList operation = new WordList();
        MyThread myThread = new MyThread();

        //yeniden input.txt dosyasından verileri tmp.txt dosyasına yazmak istersem
        //reader.inputReader();

        System.out.println("Please wait, the file upload process will take between 3-4 minutes.");
        myThread.start();
        operation.createArrayList();
        operation.returnStr(reader.tmpReader());

        int choice;
        System.out.println();
        System.out.println("Welcome....");
        do {
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("1. Search Word");
            System.out.println("2. The 10 Most Repetitive Words");
            System.out.println("3. To Save Arraylist To New File");
            System.out.println("4. Exist");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            System.out.println("--------------------------------------------------------------------------------------------");


            switch (choice) {
                case 1:
                    operation.research();
                    break;
                case 2:
                    operation.getTop10WordWithHighestFreq();
                    break;
                case 3:
                    operation.writer();
                    System.out.println("Data written to out.txt.");
                    break;
                case 4:
                    System.out.println("Goodbye...See you...");
                    break;
                default:
                    System.out.println("You made the wrong choice, please try again(1-4).");
                    break;
            }

        } while (choice != 4);
    }
}