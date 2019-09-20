package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Totek {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int licznik = 0;
        int[] gracz = new int[6];

        while (licznik != 6) {
            boolean spr = true;

            System.out.println("podaj unikalną liczbę 1-49");
            int liczba = scanner.nextInt();

            for (int i = 0; i < 6; i++) {
                if (liczba == gracz[i]) {
                    spr = false;
                }
            }
            if (liczba < 1 || liczba > 49) {
                System.out.println("Liczba poza zakresem - wpisz jeszcze raz");
            } else if (spr == true) {
                gracz[licznik] = liczba;
                licznik++;
            } else {
                System.out.println("liczba już była podana, podaj inną");
            }
        }
            System.out.println(Arrays.toString(gracz));


    }
}