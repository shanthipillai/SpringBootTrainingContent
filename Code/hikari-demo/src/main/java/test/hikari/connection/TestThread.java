package test.hikari.connection;

import java.sql.Connection;

public class TestThread extends Thread {

    public void run() {

        try {

            Connection con = HikariConnection.getConnection();

            System.out.println(
                    Thread.currentThread().getName()
                    + " using connection -> "
                    + con);

            Thread.sleep(2000);

            con.close();  // returns connection to pool

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}