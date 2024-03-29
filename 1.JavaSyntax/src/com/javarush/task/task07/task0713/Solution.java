package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число нацело делится на 3 (x%3==0), нацело делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
Порядок объявления списков очень важен.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> listNoOne = new ArrayList<>();
        int buffer;

        for (int i = 0; i < 20; i++) {
            buffer = Integer.parseInt(reader.readLine());
            list.add(buffer);
            if (buffer % 2 != 0 && buffer % 3 != 0) {
                listNoOne.add(buffer);
            } else {
                if (buffer % 2 == 0) list2.add(buffer);
                if (buffer % 3 == 0) list3.add(buffer);
            }
        }

        printList(list3);
        printList(list2);
        printList(listNoOne);
    }

    public static void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.println(i);
        }
        
    }
}
