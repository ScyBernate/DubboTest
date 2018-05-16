package com.example.feign1.biz;

import com.example.feign1.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user-service-1")
public class UserBiz {

    @RequestMapping(method = RequestMethod.GET, value = "/getuser")
    public User getuserinfo(){
        return new User(10000000l,"盛重阳", "123456","必要之恶","男","shengchongyang@hotmail.com");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserById/{id}")
    public  String  info(@PathVariable("id") int id){
        return String.format("id为%d的用户名为%s",id,"盛重阳");
    }

}
