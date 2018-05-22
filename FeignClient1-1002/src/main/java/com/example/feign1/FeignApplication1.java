package com.example.feign1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import javax.servlet.ServletRequest;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@SpringCloudApplication
public class FeignApplication1
{
    public static void main( String[] args )
    {
       SpringApplication.run(FeignApplication1.class,args);
    }
}
