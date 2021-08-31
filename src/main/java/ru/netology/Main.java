package ru.netology;

public class Main {

    public static int[] randArray() {
        int min = 0;
        int max = 1000000;
        int sizeOfArray = 10;
        int[] anArray = new int[sizeOfArray];

        for(int x = 0; x < anArray.length; x++) {
            anArray[x] = min + (int)(Math.random() * ((max - min) + 1));
        }
        return anArray;
    }


    public static void main(String[] args) throws InterruptedException {

        Tax tax = new Tax();

        Thread thread1 = new Thread(null, () -> tax.transfer(randArray()), "Магазин 1");
        Thread thread2 = new Thread(null, () -> tax.transfer(randArray()), "Магазин 2");
        Thread thread3 = new Thread(null, () -> tax.transfer(randArray()), "Магазин 3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread3.join();
        thread2.join();
        thread1.join();

        System.out.println("\nИтоговая сумма: " + tax.result());
    }
}
