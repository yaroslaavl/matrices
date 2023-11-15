package Macierze;



public class Model {
    private int[][] macierzA;
    private  int[][] macierzB;
    private  int[][] macierzC;

    public int[][] getMacierzA() {
        return macierzA;
    }

    public  int[][] getMacierzB() {
        return macierzB;
    }

    public  int[][] getMacierzC() {
        return macierzC;
    }

    public void setMacierzA(int[][] macierzA) {
       this.macierzA = macierzA;
    }

    public void setMacierzB(int[][] macierzB) {
         this.macierzB = macierzB;
    }

    public  void setMacierzC(int[][] macierzC) {
        this.macierzC = macierzC;
    }

    public int[][] transponowanieMacierz(int[][] macierz) {
        int wiersz = macierz.length;
        int col = macierz[0].length;
        int[][] transponowanaMacierz = new int[col][wiersz];

        for (int i = 0; i < wiersz; i++) {
            for (int j = 0; j < col; j++) {
                transponowanaMacierz[j][i] = macierz[i][j];
            }
        }
        return transponowanaMacierz;
    }

    public int[][] mnozenieMacierze(int[][] macierzA, int[][] macierzB) {
        int[][] wynikM = new int[macierzA.length][macierzB[0].length];
        for (int i = 0; i < macierzA.length; i++) {
            for (int j = 0; j < macierzB[0].length; j++) {
                for (int l = 0; l < macierzA[0].length; l++) {
                    wynikM[i][j] = macierzA[i][l] * macierzB[l][j];
                }
            }
        }
        return wynikM;
    }
}
