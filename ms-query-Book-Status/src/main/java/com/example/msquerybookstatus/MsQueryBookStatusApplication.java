package com.example.msquerybookstatus;

import com.example.coreapi.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AxonConfig.class})
public class MsQueryBookStatusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsQueryBookStatusApplication.class, args);
    }

}
