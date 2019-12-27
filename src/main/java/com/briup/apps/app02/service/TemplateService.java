package com.briup.apps.app02.service;

import com.briup.apps.app02.bean.Result;
import com.briup.apps.app02.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TemplateService{
    private RestTemplate restTemplate;

//    private final RestTemplate restTemplate;
//
//    @Autowired
//    public TemplateService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    public <UserEntity> Result addUser(@RequestBody UserEntity userEntity) {
        HttpEntity<UserEntity> entity = new HttpEntity<>(userEntity);
        ResponseEntity<Result> resultResponseEntity = this.restTemplate.exchange(
                "http://localhost:8082/users/findAll",
                HttpMethod.POST, entity, Result.class);
        if (resultResponseEntity.getStatusCode() == HttpStatus.OK) {
            return resultResponseEntity.getBody();
        }
        return null;
    }


    public Result callGet(long id){
        Map<String,String> map = new HashMap();
        map.put("start","1");
        map.put("page","5");
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.getForObject("http://localhost:8082/users/findAll"
                , Result.class, map);

    }

    public String callPost(User user){
        String url = "http://47.376.457.96/register/checkEmail";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("email", "844072586@qq.com");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
        System.out.println(response.getBody());
        return response.toString();
    }


}
