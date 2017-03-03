package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap <String, Integer> m=new HashMap<>();
        try (Scanner s = new Scanner(new File("file.txt"), "Cp1251")) {
            while (s.hasNext()) {
                String word=s.next();
                if (m.containsKey(word)) {
                    int count = m.get (word);
                    count++;
                    m.put (word, count);
                }
                else {
                    m.put (word, 1);
                }
            }
        }
        Set<Map.Entry <String, Integer>>
                set=m.entrySet();
        ArrayList<Map.Entry <String, Integer>>
                list=new ArrayList<>(set);
        list.sort((e1, e2) ->- e1.getValue().compareTo(e2.getValue()));
        for (Map.Entry <String, Integer> e: list) {
            System.out.println(e);
        }

    }

}