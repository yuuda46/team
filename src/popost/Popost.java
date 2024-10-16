package popost;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Popost implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // アプリケーションの起動時の処理
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // アプリケーションの停止時にJDBCドライバを解除
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

