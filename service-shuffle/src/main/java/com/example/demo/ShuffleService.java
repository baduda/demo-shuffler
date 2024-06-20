package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Service
public class ShuffleService {
    @Value("${service.log.url}")
    private final String logServiceUrl;
    private final RestTemplate restTemplate;

    public ShuffleService(@Value("${service.log.url}") String logServiceUrl) {
        this.logServiceUrl = logServiceUrl;
        this.restTemplate = new RestTemplate();
    }

    public List<Integer> shuffleArray(int number) {
        var numbers = IntStream.rangeClosed(1, number).boxed().collect(toList());
        Collections.shuffle(numbers);

        ForkJoinPool.commonPool()
                .execute(() -> restTemplate.postForEntity(logServiceUrl + "/log", numbers, Void.class));
        return numbers;
    }
}
