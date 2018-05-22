package com.example.feign1.biz;

import com.example.feign1.bean.User;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("providerService")
public interface UserBiz {

    @RequestLine("GET /getResult")
    public int count();

}
