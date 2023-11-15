package Macierze;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Model mod = new Model();
        View view = new View();
        Controller controller = new Controller(mod, view);
        int wybor;
        do {
            System.out.println("Menu");
            System.out.println("(1) Wprowadź macierze wejściowe");
            System.out.println("(2) Operacje arytmetyczne");
            System.out.println("(4) Transponuj macierze wejściowe");
            System.out.println("(5) Pomnóz macierze wejściowe");
            System.out.println("(6) Transponuj macierz wynikowa");
            System.out.println("(3) Wyświetl macierze");
            System.out.println("(0) Wyjście");
            System.out.println("Wybierz opcje:");
            wybor = scanner.nextInt();
            switch (wybor) {
                case 1:
                    controller.wprowadzenieMacierze(scanner);
                    break;
                case 2:
                    controller.operacjeArytmetyczne(scanner);
                    break;
                case 3:
                    controller.wyswietlanie();
                    break;
                case 0:
                    System.out.println("Wyjście");
                    System.exit(0);
                default:
                    System.out.println("Spróbuj ponownie");
            }
        } while (wybor != 0);
    }
}