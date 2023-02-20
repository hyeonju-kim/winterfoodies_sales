package com.winterfoodies;


import com.winterfoodies.dto.Sales;
import com.winterfoodies.mapper.SalesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {

    private final SalesMapper salesMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
