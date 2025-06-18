package com.playdata.productservice.client;

import com.playdata.productservice.review.dto.OrderResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ordering-service", url = "http://user-service.default.svc.cluster.local:8083") // 호출하고자 하는 서비스 이름 (유레카에 등록된)
public interface OrderServiceClient {

    // 사용자의 전체 주문 조회 (email로 조회)
    @GetMapping("/orders/userOrder")
    public List<OrderResponseDto> getOrdersServer(@RequestParam("email") String email);

}