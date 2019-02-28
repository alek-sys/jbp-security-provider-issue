package com.example.jbpsecurityproviderissue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;
import java.security.Security;
import java.util.Arrays;

@RestController
public class IndexController {

    @GetMapping("/")
    public String[] providers() {
        String[] providers = Arrays.stream(Security.getProviders())
                .map(Provider::getName)
                .toArray(String[]::new);

        return providers;
    }
}
