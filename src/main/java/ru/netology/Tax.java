package ru.netology;

import java.util.Arrays;
import java.util.concurrent.atomic.LongAdder;

public class Tax {

    LongAdder total = new LongAdder();

    public void transfer(int[] arr) {
        for(int el : arr) {
            total.add(el);
        }
        System.out.println(Thread.currentThread().getName() + " отправил отчет: " + Arrays.toString(arr));
    }

    long result() {
        return total.sum();
    }
}
