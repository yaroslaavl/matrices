package Macierze;
import java.util.Arrays;

class View{
    public void wyswietlanie(String nazwaM,int[][]macierz){
        System.out.println(nazwaM + ":");
        System.out.println(Arrays.deepToString(macierz).replace("],","]\n").replace("[[","[").replace("]]","]"));
        System.out.println();
    }
}