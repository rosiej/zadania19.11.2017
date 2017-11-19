package pl.sdacademy.java7krkr;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(countSmallA("ala ma kota"));
        System.out.println(decode("abcABCxyzXYZ", 1));
    }


    public static int countSmallA(String line) {


        int a = 0;// zmienna ktora mi policzy ile razy w tablicy wystepuje char a

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'a') {
                a += 1;
            }
        }
        return a;
    }

    public static int ALPHABET_SIZE = 'z' - 'a' + 1;

    public static String encode(String text, int number) {
        if(number<0){
            throw new IllegalArgumentException("number < 0");
        }
        char[] chars = text.toCharArray(); //zamieniamy tekst w tablice charow
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // chary to po prostu przechowuja numery indeksow z tablicy znakow wiec mozna je odejmowac i dodawac
            char a;

            if (Character.isLowerCase(c)) {
                a = 'a';
            } else if (Character.isUpperCase(c)) {
                a = 'A';
            } else {
                continue;
            }
            c -= a;

            c += number;

            c %= ALPHABET_SIZE;

            c += a;

            chars[i] = c;

        }
        return String.valueOf(chars);
    }

    public static String decode(String text, int number) {
        if(number<0){
            throw new IllegalArgumentException("number < 0");
        }
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            char a;

            if (Character.isLowerCase(c)) { // tutaj porzadkujemy zeby cawsze niezaleznie od wielkosci litery byla
                a = 'a';                    // byla przypozadkowana odpowiednia liczba czyli dla A i a = 0
            } else if (Character.isUpperCase(c)) { // potrzebne to bedzie tylko zeby uproscic obliczenia potem na koncu konwertujemy ponownei
                a = 'A';
            } else {
                continue; // jeslin char nie bedzie literka to go pominienmy
            }
            c -= a;

            c += ALPHABET_SIZE;
            c -= number % ALPHABET_SIZE;
// u gory i na dole mamy dwa rozne podejscia ktore dadza ten sam wynik chodzi o to zeby nie uzyskac liczby ujemnej
//            c += ALPHABET_SIZE * (number / ALPHABET_SIZE + 1);
//            c -= number;

            c %= ALPHABET_SIZE;

            c += a;

            chars[i] = c;

        }
        return String.valueOf(chars);
    }
}



