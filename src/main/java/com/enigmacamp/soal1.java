package com.enigmacamp;

import java.util.ArrayList;
import java.util.List;

public class soal1 {
    public static List<List<String>> kelompokkanAnagram(String[] kataKata) {

        for (int i = 0; i < kataKata.length; i++) {
            kataKata[i] = ubahKeHurufKecil(kataKata[i]);
        }

        List<List<String>> hasil = new ArrayList<>();
        boolean[] sudahDikunjungi = new boolean[kataKata.length];

        for (int i = 0; i < kataKata.length; i++) {
            if (!sudahDikunjungi[i]) {
                List<String> kelompok = new ArrayList<>();
                kelompok.add(kataKata[i]);
                sudahDikunjungi[i] = true;

                for (int j = i + 1; j < kataKata.length; j++) {
                    if (!sudahDikunjungi[j] && apakahAnagram(kataKata[i], kataKata[j])) {
                        kelompok.add(kataKata[j]);
                        sudahDikunjungi[j] = true;
                    }
                }

                hasil.add(kelompok);
            }
        }

        return hasil;
    }

    private static String ubahKeHurufKecil(String kata) {
        char[] karakter = kata.toCharArray();
        for (int i = 0; i < karakter.length; i++) {
            if (karakter[i] >= 'A' && karakter[i] <= 'Z') {
                karakter[i] += 32;
            }
        }
        return new String(karakter);
    }

    private static boolean apakahAnagram(String kata1, String kata2) {
        if (kata1.length() != kata2.length()) {
            return false;
        }

        int[] frekuensi1 = new int[26];
        int[] frekuensi2 = new int[26];
        for (char c : kata1.toCharArray()) {
            frekuensi1[c - 'a']++;
        }
        for (char c : kata2.toCharArray()) {
            frekuensi2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (frekuensi1[i] != frekuensi2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] kataKata = {"cook", "save", "taste", "aves", "vase", "state", "map"};
        List<List<String>> kelompokAnagram = kelompokkanAnagram(kataKata);

        System.out.println(kelompokAnagram);
    }
}
