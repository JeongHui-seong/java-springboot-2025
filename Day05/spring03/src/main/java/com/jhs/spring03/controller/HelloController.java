package com.jhs.spring03.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // SpringBoot에서 컨트롤러로 동작 지칭 주석(annotation)
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/hello") // 웹 서비스에서 사용할 길 만들기, /hello
    @ResponseBody
    public String helloSpring() {
        logger.info("Hello URL 오픈");
        // 문제발생 시 로그를 남길 대
        logger.debug("디버그시 필요한 로그(디버그)");
        logger.trace("디버그시 필요한 로그(트레이스)");
        
        logger.warn("경고 표시 나타나는 로그");
        logger.error("오류 표시 나타내는 로그");
        return "Hello SpringBoot";
    }
}
