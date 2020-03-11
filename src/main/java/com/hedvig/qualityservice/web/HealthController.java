package com.hedvig.qualityservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/_health")
public class HealthController {
    @GetMapping("/ping")
    public Map<String, String> ping() {
        return new HashMap<String, String>() {{
            put("ping", "pong");
        }};
    }
}
