package com.example.demo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ShuffleNumbersRequest(@NotNull(message = "Number is required")
                                    @Min(value = 1, message = "Number must be at least 1")
                                    @Max(value = 1000, message = "Number must be at most 1000")
                                    int number) {
}
