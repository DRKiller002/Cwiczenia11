import java.util.Scanner;
public class MyThreadVer3 implements Runnable {
    Thread thread;

    MyThreadVer3(String name) {
        thread = new Thread(this, name);
    }

    public static MyThreadVer3 createAndStart(String name) {
        MyThreadVer3 myThreadVer3 = new MyThreadVer3(name);
        myThreadVer3.thread.start();
        return myThreadVer3;
    }

    public void run() {
        System.out.println(thread.getName() + "rozpoczyna działanie");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println(thread.getName() + "jest wykonywany, wartość licznika:" + count);
            }
        } catch (InterruptedException e) {
            System.out.println(thread.getName() + "został przerwany");
        }
        System.out.println(thread.getName() + "kończy działanie");
    }
}
        class MoreThreads2{
            public static void main(String[] args){
                System.out.println("Główny wątek rozpoczyna działanie");
                MyThreadVer3 myThread1= MyThreadVer3.createAndStart("Wątek potomny nr 1");
                MyThreadVer3 myThread2= MyThreadVer3.createAndStart("Wątek potomny nr 2");
                MyThreadVer3 myThread3= MyThreadVer3.createAndStart("Wątek potomny nr 3");

                try{
                    myThread1.thread.join();
                    System.out.println("Wątek potomny 1 zakończony");
                    myThread2.thread.join();
                    System.out.println("Wątek potomny 2 zakończony");
                    myThread3.thread.join();
                    System.out.println("Wątek potomny 3 zakończony");
                } catch (InterruptedException e){
                    System.out.println("Główny wątek zakończony");
                }

//                do{
//                    System.out.print(".");
//                    try{
//                        Thread.sleep(100);
//                    }catch(InterruptedException e){
//                        System.out.println("Wątek główny został przerwany");
//                    }
//                } while(myThread1.thread.isAlive() || myThread2.thread.isAlive() || myThread3.thread.isAlive());
                System.out.println("Wątek główny kończy działanie");
            }
        }


