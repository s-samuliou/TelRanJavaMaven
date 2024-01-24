package com.proftelran.org.lessontwentyeight;

public class TestNoSyncTwo {

    private static int counter = 0;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    // 1. - Чтение текущего значения
                    // 2. - Увеличение на 1
                    // 3. - Присвоение нового значения в переменную
                    synchronized (this){
                        counter++;
                    }
                    /*try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }*/

                    /*System.out.println("" +
                            Thread.currentThread().getName() + " : iterator " +
                            i + " : " + counter);*/
                }
            }
        };

        Thread threadOne = new Thread(runnable);
        Thread threadTwo = new Thread(runnable);
        Thread threadThree = new Thread(runnable);

        long startTime = System.currentTimeMillis();
        threadOne.start();
        threadTwo.start();
        threadThree.start();

        // join - усыпляет поток в котором он вызван
        // пока поток у которого он вызван не завершит свою работу
        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter " + counter);
        System.out.println("Execute time = " + (System.currentTimeMillis() - startTime));
    }
}
