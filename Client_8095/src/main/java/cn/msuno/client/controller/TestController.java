package cn.msuno.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hi(){
        return restTemplate.getForObject("http://msuno-server/service-instances/msuno-server", String.class);
    }
    
    @RequestMapping("/test")
    public Object test(){
    	
        Object sl= restTemplate.getForObject("http://msuno-server/service-instances/test", Object.class);
        System.out.println(sl);
        return sl;
    }
}
