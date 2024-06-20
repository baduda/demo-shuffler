package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class ShuffleController {
    private final ShuffleService shuffleService;

    public ShuffleController(ShuffleService shuffleService) {
        this.shuffleService = shuffleService;
    }

    @PostMapping("/shuffle")
    public List<Integer> shuffle(@Valid @RequestBody ShuffleNumbersRequest request) {
        return shuffleService.shuffleArray(request.number());
    }
}
