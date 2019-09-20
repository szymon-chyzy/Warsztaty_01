package com.company;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        System.out.println("Pomyśl liczbę od 0 do 1000, zgadnę ją w max. 10 próbach.");

        int min = 0;
        int max = 1000;
        int podpowiedz = 0;
        int guess = 0;
        int i = 0;

        while (podpowiedz != 3) {

            guess = (max - min) / 2 + min;
            System.out.println("Zgaduję: " + guess);

            Scanner scan = new Scanner(System.in);

            System.out.println("Wpisz cyfrę: 1. za dużo   2. za mało   3. zgadłeś");
            podpowiedz = scan.nextInt();

            if (podpowiedz == 1 && i < 11) {
                max = guess;
                i++;

            } else if (podpowiedz == 2 && i < 11) {
                min = guess;
                i++;

            } else if (i > 10) {
                System.out.println("Oszukujesz - coś tutaj śmierdzi");
                break;

            } else if (podpowiedz == 3) {
                System.out.println("Zgadłem - twoja liczba to " + guess + ", zgadłem za " + i + " razem");

            } else {
                System.out.println("#$%$# yy_*przepraszam, nie zrozumiałem, wróćmy do poprzedniego kroku");

            }

        }

    }

}
