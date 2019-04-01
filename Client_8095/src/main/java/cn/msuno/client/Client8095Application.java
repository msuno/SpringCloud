package cn.msuno.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class Client8095Application {

	public static void main(String[] args) {
		SpringApplication.run(Client8095Application.class, args);
	}
	
	@Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
	

}
