package com.qhb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
@SpringBootConfiguration
//@EnableCaching
//@MapperScan("com.qhb.mapper")
public class QbvConsumerApplication {

    public static void main(String[] args) throws IOException {
        System.out.println("QhbNmApplication used!!!!!!");
        /*Properties properties = new Properties();
        InputStream in = QhbNmApplication.class.getClassLoader().getResourceAsStream("application.properties");
        System.out.println("line: " + in.available());
        properties.load(in);
        SpringApplication app = new SpringApplication(QhbNmApplication.class);
        app.setDefaultProperties(properties);
        app.run(args);*/
        SpringApplication.run(QbvConsumerApplication.class, args);
    }

    /*private void test(){
    Properties properties = new Properties();
        InputStream in = QhbNmApplication.class.getClassLoader().getResourceAsStream("application.properties");
        System.out.println("line: " + in.available());
        properties.load(in);
        SpringApplication app = new SpringApplication(QhbNmApplication.class);
        app.setDefaultProperties(properties);
        app.run(args);
    }*/
}
