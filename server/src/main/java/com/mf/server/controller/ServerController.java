package com.mf.server.controller;

import com.mf.common.api.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @GetMapping("/test")
    public BaseResponse<String> test () {
        BaseResponse<String> response = new BaseResponse<>();
        response.setResult("zp");
        response.setStatus(true);
        return response;
    }

}
