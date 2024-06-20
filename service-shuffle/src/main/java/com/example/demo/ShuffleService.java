package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Service
public class ShuffleService {
    private final LogClient logClient;

    public ShuffleService(LogClient logClient) {
        this.logClient = logClient;
    }

    public List<Integer> shuffleArray(int maxNumber) {
        var numbers = IntStream.rangeClosed(1, maxNumber).boxed().collect(toList());
        Collections.shuffle(numbers);

        logClient.log(numbers);
        return numbers;
    }
}
