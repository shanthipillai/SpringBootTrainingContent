package test.hikari.connection;

public class TestHikari {

    public static void main(String[] args) {

        for(int i=1;i<=10;i++) {

            TestThread t = new TestThread();
            t.start();

        }

    }

} 