package Macierze;

import java.util.InputMismatchException;
import java.util.Scanner;

class Controller {
    private Model mod;
    private View view;

    public Controller(Model mod, View view) {
        this.mod = mod;
        this.view = view;
    }

    public void wprowadzenieMacierze(Scanner scanner) {
        int[][] macierzA = zrobienieMacierze(scanner, "A");
        int[][] macierzB = zrobienieMacierze(scanner, "B");
        mod.setMacierzA(macierzA);
        mod.setMacierzB(macierzB);
        System.out.println("Macierze wejściowe wprowadzone");
    }

    private int[][] zrobienieMacierze(Scanner scanner, String mNazwa) {
        System.out.println("Podaj liczbę wierszy macierzy " + mNazwa + ": ");
        int wiersz = scanner.nextInt();
        System.out.println("Podaj liczbę column macierzy" + mNazwa + ": ");
        int col = scanner.nextInt();
        return zrobienieMacierze(scanner, wiersz, col, mNazwa);
    }

    private int[][] zrobienieMacierze(Scanner scanner, int wiersz, int col, String mNazwa) {
        int[][] macierz = new int[wiersz][col];
        System.out.println("Wprowadź wartości dla macierzy " + mNazwa + ": ");
        for (int i = 0; i < wiersz; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println(mNazwa + "[" + i + "][" + j + "]: ");
                macierz[i][j] = scanner.nextInt();
            }
        }
        return macierz;
    }

    public void operacjeArytmetyczne(Scanner scanner) {
        if (mod.getMacierzA() == null || mod.getMacierzB() == null) {
            System.err.println("Błąd");
            return;
        }
        System.out.println("Operacje arytmetyczne:");
        System.out.println("(4) Transponuj macierze wejściowe");
        System.out.println("(5) Pomnóz macierze wejściowe");
        System.out.println("(6) Transponuj macierz wynikowa");
        System.out.println("Wybierz opcję: ");
        int wybor2 = scanner.nextInt();
        try {
            if (wybor2 == 4) {
                transponowanaMacierzA();
                transponowanaMacierzB();
            } else if (wybor2 == 5) {
                mnozenieMacierze();
            } else if (wybor2 == 6) {
                transponowanaMacierzC();
            } else {
                System.out.println("Spróbuj ponownie");
            }
        } catch (InputMismatchException e) {
            System.out.println("Błąd:InputMismatchException");
            scanner.nextLine();
        }
    }

    private void transponowanaMacierzA() {
        int[][] transponowanaA = mod.transponowanieMacierz(mod.getMacierzA());
        mod.setMacierzA(transponowanaA);
        view.wyswietlanie("Macierz A", transponowanaA);
    }

    private void transponowanaMacierzB() {
        int[][] transponowanaB = mod.transponowanieMacierz(mod.getMacierzB());
        mod.setMacierzB(transponowanaB);
        view.wyswietlanie("Macierz B", transponowanaB);
    }

    private void transponowanaMacierzC() {
        int[][] transponowanaC = mod.transponowanieMacierz(mod.getMacierzC());
        mod.setMacierzC(transponowanaC);
        view.wyswietlanie("Macierz B", transponowanaC);
    }

    public void mnozenieMacierze() {
        int[][] macierzA = mod.getMacierzA();
        int[][] macierzB = mod.getMacierzB();
        if (macierzA != null || macierzB != null) {
            if (macierzA[0].length == macierzB.length) {
                int[][] macierzC = mod.mnozenieMacierze(macierzA, macierzB);
                mod.setMacierzC(macierzC);
                view.wyswietlanie("Macierz A i B są pomnożone", macierzC);
            } else {
                System.err.println("Błąd");
            }
        } else {
            System.err.println("Błąd");
        }
    }
    public void wyswietlanie() {
        int[][] macierzA = mod.getMacierzA();
        int[][] macierzB = mod.getMacierzB();
        int[][] macierzC = mod.getMacierzC();
        if (macierzA != null && macierzB != null && macierzC!=null) {
            view.wyswietlanie("Macierz A", macierzA);
            view.wyswietlanie("Macierz B", macierzB);
            view.wyswietlanie("Macierz C", macierzC);
        }
    }
}
