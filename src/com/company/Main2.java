package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {

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

        Arrays.sort(gracz);
        System.out.println(Arrays.toString(gracz));


        int[] losowanie = new int[6];

        Integer[] arr = new Integer[49];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = j + 1;
        }

        Collections.shuffle(Arrays.asList(arr));

        for (int k = 0; k < 6; k++) {
            losowanie[k] = arr[k];
        }

        Arrays.sort(losowanie);

        System.out.println("Maszyna losująca jest pusta, następuje zwolnienie blokady: " + Arrays.toString(losowanie));
        System.out.println("Twoje liczby to: " + Arrays.toString(gracz));

        int traf = 0;
        for (int i = 0; i < 6 ; i++) {
            for (int j = 0; j < 6; j++) {
                if (losowanie[i]==gracz[j]) {
                        traf++;
                }
            }



        }

        System.out.println("Trafiłeś = " + traf);
    }

}