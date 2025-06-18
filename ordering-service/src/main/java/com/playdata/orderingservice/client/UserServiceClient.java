package com.playdata.orderingservice.client;

import com.playdata.orderingservice.common.dto.CommonResDto;
import com.playdata.orderingservice.ordering.dto.UserResDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", url = "http://user-service.default.svc.cluster.local:8081") // 호출하고자 하는 서비스 이름 (유레카에 등록된)
public interface UserServiceClient {

    @GetMapping("/user/findByEmail")
    CommonResDto<UserResDto> findByEmail(@RequestParam String email);

}










