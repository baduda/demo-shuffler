package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class ShuffleController {
    private final ShuffleService shuffleService;

    public ShuffleController(ShuffleService shuffleService) {
        this.shuffleService = shuffleService;
    }

    @PostMapping("/shuffle")
    public List<Integer> shuffle(@RequestParam int number) {
        return shuffleService.shuffleArray(number);
    }
}
